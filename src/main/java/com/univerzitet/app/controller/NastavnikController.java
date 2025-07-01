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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.NastavnikDTO;
import com.univerzitet.app.dto.ZvanjeDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.mapper.NastavnikMapper;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.DodeljenoPravoPristupa;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.PravoPristupa;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.repo.PravoPristupaRepo;
import com.univerzitet.app.service.AdresaService;
import com.univerzitet.app.service.NastavnikService;
import com.univerzitet.app.service.RegistrovaniKorisnikService;
import com.univerzitet.app.service.ZvanjeService;

@RestController
@RequestMapping("/api/nastavnici")
public class NastavnikController extends GenericController<Nastavnik>{

	private RegistrovaniKorisnikService korisnikService;
	
	private NastavnikService nastavnikService;
	
	private NastavnikMapper nastavnikMapper;
	
	private AdresaService adresaService;
	
	private PravoPristupaRepo pravoPristupaRepo;
	
	private ZvanjeService zvanjeService;

	@Autowired
	public NastavnikController(GenericService<Nastavnik, Long> service, RegistrovaniKorisnikService korisnikService,
			NastavnikService nastavnikService, NastavnikMapper nastavnikMapper, AdresaService adresaService,
			PravoPristupaRepo pravoPristupaRepo, ZvanjeService zvanjeService) {
		super(service);
		this.korisnikService = korisnikService;
		this.nastavnikService = nastavnikService;
		this.nastavnikMapper = nastavnikMapper;
		this.adresaService = adresaService;
		this.pravoPristupaRepo = pravoPristupaRepo;
		this.zvanjeService = zvanjeService;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<NastavnikDTO>> getAllNastavnici() {
		List<NastavnikDTO> dtos = StreamSupport.stream(nastavnikService.findAll().spliterator(), false)
				.map(nastavnikMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<NastavnikDTO> getById(@PathVariable Long id) {
		Nastavnik nastavnik = nastavnikService.findById(id);
		return nastavnik != null ? ResponseEntity.ok(nastavnikMapper.mapToDTO(nastavnik)) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/kreiraj")
	public ResponseEntity<NastavnikDTO> create(@RequestBody NastavnikDTO dto) {
		if (korisnikService.postojiKorisnikSaKorisnickimImenom(dto.getKorisnickoIme())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
		
		if (korisnikService.postojiKorisnikSaEmailom(dto.getEmail())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
		
		Nastavnik nastavnik = nastavnikMapper.mapToEntity(dto);
		
		if (dto.getAdresa() != null) {
			Adresa adresa = adresaService.save(dto.getAdresa());
			
			nastavnik.setAdresa(adresa);
		}
		
		Set<DodeljenoPravoPristupa> dodeljenaPrava = new HashSet<>();
		DodeljenoPravoPristupa dodeljenoPravo = new DodeljenoPravoPristupa();
		PravoPristupa pravoPristupa = pravoPristupaRepo.findByNaziv("ROLE_NASTAVNIK");
		
		if (pravoPristupa == null) {
            throw new RuntimeException("Pravo pristupa ne postoji.");
		}
		
		dodeljenoPravo.setPravoPristupa(pravoPristupa);
		dodeljenoPravo.setRegistrovaniKorisnik(nastavnik);
		dodeljenaPrava.add(dodeljenoPravo);
		
		nastavnik.setDodeljenaPrava(dodeljenaPrava);
		
		if (dto.getZvanja() != null && !dto.getZvanja().isEmpty()) {
			for (ZvanjeDTO zvanjeDto : dto.getZvanja()) {
				NastavnikDTO nastavnikZaZvanje = new NastavnikDTO();
				nastavnikZaZvanje.setId(nastavnik.getId());
				zvanjeDto.setNastavnik(nastavnikZaZvanje);
				zvanjeService.save(zvanjeDto);
			}
		}
		
		korisnikService.save(nastavnik);
		return ResponseEntity.ok(nastavnikMapper.mapToDTO(nastavnik));
	}
}
