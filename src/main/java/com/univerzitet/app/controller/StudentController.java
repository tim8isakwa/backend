package com.univerzitet.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.univerzitet.app.dto.ObavestenjeDTO;
import com.univerzitet.app.dto.StudentDTO;
import com.univerzitet.app.dto.StudentNaGodiniDTO;
import com.univerzitet.app.dto.StudentPredmetDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.mapper.StudentMapper;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.DodeljenoPravoPristupa;
import com.univerzitet.app.model.GodinaStudija;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.PravoPristupa;
import com.univerzitet.app.model.RegistrovaniKorisnik;
import com.univerzitet.app.model.Student;
import com.univerzitet.app.model.StudentNaGodini;
import com.univerzitet.app.repo.PravoPristupaRepo;
import com.univerzitet.app.service.AdresaService;
import com.univerzitet.app.service.RegistrovaniKorisnikService;
import com.univerzitet.app.service.StudentService;

@RestController
@RequestMapping("/api/studenti")
public class StudentController extends GenericController<Student> {

    private final StudentService studentService;
    private final StudentMapper studentMapper;
    private final RegistrovaniKorisnikService korisnikService;
    private final AdresaService adresaService;
    private final PravoPristupaRepo pravoPristupaRepo;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper,
                             RegistrovaniKorisnikService korisnikService, AdresaService adresaService,
                             PravoPristupaRepo pravoPristupaRepo) {
        super(studentService);
        this.studentService = studentService;
        this.studentMapper = studentMapper;
        this.korisnikService = korisnikService;
        this.adresaService = adresaService;
        this.pravoPristupaRepo = pravoPristupaRepo;
    }

    @GetMapping("/{id}/predmeti")
    public ResponseEntity<List<StudentPredmetDTO>> getPredmetiKojeSlusa(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getPredmetiKojeSlusa(id));
    }

    @GetMapping("/{id}/obavestenja")
    public ResponseEntity<List<ObavestenjeDTO>> getObavestenja(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getObavestenjaZaPredmete(id));
    }

    @PreAuthorize("hasRole('OSOBLJE')")
    @GetMapping("")
    public ResponseEntity<List<StudentDTO>> getAllStudenti() {
        List<StudentDTO> dtos = StreamSupport.stream(studentService.findAll().spliterator(), false)
                .map(studentMapper::mapToDTO).collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return student != null ? ResponseEntity.ok(studentMapper.mapToDTO(student)) : ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('OSOBLJE')")
    @PostMapping("/kreiraj")
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO dto) {
    	
    	if (korisnikService.postojiKorisnikSaKorisnickimImenom(dto.getKorisnickoIme())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
		
		if (korisnikService.postojiKorisnikSaEmailom(dto.getEmail())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
    	
        Student student = studentMapper.mapToEntity(dto);

        if (dto.getAdresa() != null) {
            Adresa adresa = adresaService.save(dto.getAdresa());
            student.setAdresa(adresa);
        }
        
        Set<StudentNaGodini> studentNaGodinama = new HashSet<>();

        for (StudentNaGodiniDTO studentNaGodiniDTO : dto.getStudentNaGodinima()) {
    		GodinaStudija godinaStudija = new GodinaStudija();
    		godinaStudija.setGodina(studentNaGodiniDTO.getGodinaStudija());
        	
        	StudentNaGodini studentNaGodini = new StudentNaGodini();
        	studentNaGodini.setGodinaStudija(godinaStudija);
        	studentNaGodini.setBrojIndeksa(studentNaGodiniDTO.getBrojIndeksa());
        	studentNaGodini.setDatumUpisa(studentNaGodiniDTO.getDatumUpisa());
   
            studentNaGodinama.add(studentNaGodini);
        }
   
        student.setStudentNaGodinima(studentNaGodinama);

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
        
		Student sacuvano = (Student) korisnikService.save(student);
        return ResponseEntity.ok(studentMapper.mapToDTO(sacuvano));
    }
}
