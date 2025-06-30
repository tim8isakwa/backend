package com.univerzitet.app.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.FakultetDTO;
import com.univerzitet.app.dto.StudijskiProgramDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.mapper.FakultetMapper;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.service.AdresaService;
import com.univerzitet.app.service.FakultetService;
import com.univerzitet.app.service.StudijskiProgramService;

@RestController
@RequestMapping("/api/fakulteti")
public class FakultetController extends GenericController<Fakultet> {

	private FakultetService fakultetService;
	
	private FakultetMapper fakultetMapper;
	
	private AdresaService adresaService;
	
	private StudijskiProgramService programService;

	@Autowired
	public FakultetController(FakultetService fakultetService,
			FakultetMapper fakultetMapper, AdresaService adresaService, StudijskiProgramService programService) {
		super(fakultetService);
		this.fakultetService = fakultetService;
		this.fakultetMapper = fakultetMapper;
		this.adresaService = adresaService;
		this.programService = programService;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<FakultetDTO>> getAllKorisnici() {
		List<FakultetDTO> dtos = StreamSupport.stream(fakultetService.findAll().spliterator(), false)
				.map(fakultetMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FakultetDTO> getById(@PathVariable Long id) {
		Fakultet fakultet = fakultetService.findById(id);
		return fakultet != null ? ResponseEntity.ok(fakultetMapper.mapToDTO(fakultet)) : ResponseEntity.notFound().build();
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/kreiraj")
	public ResponseEntity<FakultetDTO> create(@RequestBody FakultetDTO dto) {
		Fakultet fakultet = fakultetMapper.mapToEntity(dto);
		
		if (dto.getAdresa() != null) {
			Adresa adresa = adresaService.save(dto.getAdresa());
			
			fakultet.setAdresa(adresa);
		}
		
		Set<StudijskiProgram> programi = new HashSet<>();
		if (dto.getProgrami() != null) {
			for (StudijskiProgramDTO programDTO : dto.getProgrami()) {
				StudijskiProgram program = programService.findByNaziv(programDTO.getNaziv());
				
				if (program != null) {
					programi.add(program);
				}
			}
		}
		
		fakultetService.save(fakultet);
		return ResponseEntity.ok(fakultetMapper.mapToDTO(fakultet));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<FakultetDTO> update(@PathVariable("id") Long id, @RequestBody FakultetDTO dto) {
		if (!fakultetService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		Fakultet fakultet = fakultetMapper.mapToEntity(dto);
		
		if (dto.getAdresa() != null) {
			Adresa adresa = adresaService.save(dto.getAdresa());
			
			fakultet.setAdresa(adresa);
		}
		
		Set<StudijskiProgram> programi = new HashSet<>();
		if (dto.getProgrami() != null) {
			for (StudijskiProgramDTO programDTO : dto.getProgrami()) {
				StudijskiProgram program = programService.findByNaziv(programDTO.getNaziv());
				
				if (program != null) {
					programi.add(program);
				}
			}
		}
		
		fakultetService.save(fakultet);
		return ResponseEntity.ok(fakultetMapper.mapToDTO(fakultet));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		if (!fakultetService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		fakultetService.deleteById(id);
		return ResponseEntity.ok("Ok");
	}
}
