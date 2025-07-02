package com.univerzitet.app.controller;

import java.util.List;
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

import com.univerzitet.app.dto.StudijskiProgramDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.mapper.StudijskiProgramMapper;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.service.StudijskiProgramService;

@RestController
@RequestMapping("/api/programi")
public class StudijskiProgramController extends GenericController<StudijskiProgram>{

	private StudijskiProgramService programService;
	
	private StudijskiProgramMapper programMapper;
	
	@Autowired
	public StudijskiProgramController(StudijskiProgramService programService, StudijskiProgramMapper programMapper) {
		super(programService);
		this.programService = programService;
		this.programMapper = programMapper;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<StudijskiProgramDTO>> getAllKorisnici() {
		List<StudijskiProgramDTO> dtos = StreamSupport.stream(programService.findAll().spliterator(), false)
				.map(programMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudijskiProgramDTO> getById(@PathVariable Long id) {
		StudijskiProgram program = programService.findById(id);
		return program != null ? ResponseEntity.ok(programMapper.mapToDTO(program)) : ResponseEntity.notFound().build();
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/kreiraj")
	public ResponseEntity<StudijskiProgramDTO> create(@RequestBody StudijskiProgramDTO dto) {
		StudijskiProgram program = programMapper.mapToEntity(dto);
		programService.save(program);
		
		return ResponseEntity.ok(programMapper.mapToDTO(program));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<StudijskiProgramDTO> update(@PathVariable("id") Long id, @RequestBody StudijskiProgramDTO dto) {
		if (!programService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		dto.setId(id);
		StudijskiProgram program = programMapper.mapToEntity(dto);
		
		programService.save(program);
		return ResponseEntity.ok(programMapper.mapToDTO(program));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		if (!programService.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		programService.deleteById(id);
		return ResponseEntity.ok("Ok");
	}
}
