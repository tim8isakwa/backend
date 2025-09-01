package com.univerzitet.app.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.PredmetDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.mapper.PredmetMapper;
import com.univerzitet.app.model.Predmet;
import com.univerzitet.app.service.PredmetService;
import com.univerzitet.app.model.Predmet;

@RestController
@RequestMapping("/api/predmeti")
public class PredmetiController extends GenericController<Predmet>{
	
	private PredmetService predmetService;
	
	private PredmetMapper predmetMapper;

	@Autowired
	public PredmetiController(PredmetService predmetService,
			PredmetMapper predmetMapper) {
		super(predmetService);
		this.predmetService = predmetService;
		this.predmetMapper = predmetMapper;
	}
	
	@GetMapping("")
	public ResponseEntity<List<PredmetDTO>> getAllPredmeti() {
		List<PredmetDTO> dtos = StreamSupport.stream(predmetService.findAll().spliterator(), false)
				.map(predmetMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<PredmetDTO> getById(@PathVariable Long id) {
		Predmet predmet = predmetService.findById(id);
		return predmet != null ? ResponseEntity.ok(predmetMapper.mapToDTO(predmet)) : ResponseEntity.notFound().build();
	}
}
