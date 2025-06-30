package com.univerzitet.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.StudentDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.mapper.StudentMapper;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.DodeljenoPravoPristupa;
import com.univerzitet.app.model.PravoPristupa;
import com.univerzitet.app.model.RegistrovaniKorisnik;
import com.univerzitet.app.model.Student;
import com.univerzitet.app.repo.PravoPristupaRepo;
import com.univerzitet.app.service.AdresaService;
import com.univerzitet.app.service.RegistrovaniKorisnikService;
import com.univerzitet.app.service.StudentService;
import com.univerzitet.app.model.Student;

@RestController
@RequestMapping("/api/studenti")
public class StudentController extends GenericController<Student>{

	private RegistrovaniKorisnikService korisnikService;
	
	private StudentService studentService;
	
	private StudentMapper studentMapper;
	
	private AdresaService adresaService;
	
	private PravoPristupaRepo pravoPristupaRepo;
	
	@Autowired
	public StudentController(RegistrovaniKorisnikService korisnikService, StudentService studentService,
			StudentMapper studentMapper, AdresaService adresaService, PravoPristupaRepo pravoPristupaRepo) {
		super(studentService);
		this.korisnikService = korisnikService;
		this.studentService = studentService;
		this.studentMapper = studentMapper;
		this.adresaService = adresaService;
		this.pravoPristupaRepo = pravoPristupaRepo;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<StudentDTO>> getAllKorisnici() {
		List<StudentDTO> dtos = StreamSupport.stream(studentService.findAll().spliterator(), false)
				.map(studentMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getById(@PathVariable Long id) {
		Student student = studentService.findById(id);
		return student != null ? ResponseEntity.ok(studentMapper.mapToDTO(student)) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/kreiraj")
	public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
		RegistrovaniKorisnik korisnik = korisnikService.findByEmail(dto.getEmail());
	
		if (korisnik != null) {
			return ResponseEntity.notFound().build();
		}
		
		Student student = studentMapper.mapToEntity(dto);
		student.setId(korisnik.getId());
		
		if (dto.getAdresa() != null) {
			Adresa adresa = adresaService.save(dto.getAdresa());
			
			student.setAdresa(adresa);
		}
		
		Set<DodeljenoPravoPristupa> dodeljenaPrava = new HashSet<>();
		DodeljenoPravoPristupa dodeljenoPravo = new DodeljenoPravoPristupa();
		PravoPristupa pravoPristupa = pravoPristupaRepo.findByNaziv("ROLE_STUDENT");
		
		if (pravoPristupa == null) {
            throw new RuntimeException("Pravo pristupa ne postoji.");
		}
		
		dodeljenoPravo.setPravoPristupa(pravoPristupa);
		dodeljenoPravo.setRegistrovaniKorisnik(student);
		dodeljenaPrava.add(dodeljenoPravo);
		
		student.setDodeljenaPrava(dodeljenaPrava);
		
		return ResponseEntity.ok(studentMapper.mapToDTO(student));
	}
}
