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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.FakultetDTO;
import com.univerzitet.app.dto.UniverzitetDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.mapper.UniverzitetMapper;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.model.Univerzitet;
import com.univerzitet.app.service.AdresaService;
import com.univerzitet.app.service.FakultetService;
import com.univerzitet.app.service.UniverzitetService;
import com.univerzitet.app.model.Univerzitet;

@RestController
@RequestMapping("/api/univerziteti")
public class UniverzitetController extends GenericController<Univerzitet> {
	
	private UniverzitetService univerzitetService;
	
	private UniverzitetMapper univerzitetMapper;
	
	private AdresaService adresaService;
	
	private FakultetService fakultetService;
	
	public UniverzitetController(UniverzitetService univerzitetService, UniverzitetMapper univerzitetMapper,
			AdresaService adresaService, FakultetService fakultetService) {
		super(univerzitetService);
		this.univerzitetService = univerzitetService;
		this.univerzitetMapper = univerzitetMapper;
		this.adresaService = adresaService;
		this.fakultetService = fakultetService;
	}

	@GetMapping("")
	public ResponseEntity<List<UniverzitetDTO>> getAllUniverziteti() {
		List<UniverzitetDTO> dtos = StreamSupport.stream(univerzitetService.findAll().spliterator(), false)
				.map(univerzitetMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UniverzitetDTO> getById(@PathVariable Long id) {
		Univerzitet univerzitet = univerzitetService.findById(id);
		return univerzitet != null ? ResponseEntity.ok(univerzitetMapper.mapToDTO(univerzitet)) : ResponseEntity.notFound().build();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("")
	public ResponseEntity<UniverzitetDTO> save(@RequestBody UniverzitetDTO dto) {
		if (dto.getId() == null || !univerzitetService.existsById(dto.getId())) {
			return ResponseEntity.notFound().build();
		}
		
		Univerzitet univerzitet = univerzitetMapper.mapToEntity(dto);
		
		if (dto.getAdresa() != null) {
			Adresa adresa = adresaService.save(dto.getAdresa());
			
			univerzitet.setAdresa(adresa);
		}
		
		Set<Fakultet> fakulteti = new HashSet<>();
		if (dto.getFakulteti() != null) {
			for (FakultetDTO fakultetDTO : dto.getFakulteti()) {
				Fakultet fakultet = fakultetService.findByNaziv(fakultetDTO.getNaziv());
				if (fakultet != null) {
        			fakulteti.add(fakultet);
        		}
			}
		}
		
		univerzitetService.save(univerzitet);
		return ResponseEntity.ok(univerzitetMapper.mapToDTO(univerzitet));
	}
	
	@Override
	public ResponseEntity<String> delete(Long id) {
		return super.delete(id);
	}
}
