package com.univerzitet.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univerzitet.app.dto.RegistrovaniKorisnikDTO;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.mapper.RegistrovaniKorisnikMapper;
import com.univerzitet.app.model.RegistrovaniKorisnik;
import com.univerzitet.app.service.RegistrovaniKorisnikService;
import com.univerzitet.app.utils.TokenUtils;

@RestController
@RequestMapping("/api/registrovaniKorisnici")
public class RegistrovaniKorisnikController extends GenericController<RegistrovaniKorisnik> {

	private RegistrovaniKorisnikService korisnikService;

	private UserDetailsService userDetailsService;

	private RegistrovaniKorisnikMapper korisnikMapper;
	
	private PasswordEncoder passwordEncoder;

	private TokenUtils tokenUtils;
	
	@Autowired
	public RegistrovaniKorisnikController(RegistrovaniKorisnikService korisnikService, UserDetailsService userDetailsService,
			RegistrovaniKorisnikMapper korisnikMapper, PasswordEncoder passwordEncoder, TokenUtils tokenUtils) {
		super(korisnikService);
		this.korisnikService = korisnikService;
		this.userDetailsService = userDetailsService;
		this.korisnikMapper = korisnikMapper;
		this.passwordEncoder = passwordEncoder;
		this.tokenUtils = tokenUtils;
	}

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("")
	public ResponseEntity<List<RegistrovaniKorisnikDTO>> getAllKorisnici() {
		List<RegistrovaniKorisnikDTO> dtos = StreamSupport.stream(korisnikService.findAll().spliterator(), false)
				.map(korisnikMapper::mapToDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<RegistrovaniKorisnikDTO> getById(@PathVariable Long id) {
		RegistrovaniKorisnik korisnik = korisnikService.findById(id);
		return korisnik != null ? ResponseEntity.ok(korisnikMapper.mapToDTO(korisnik)) : ResponseEntity.notFound().build();
	}

	@PostMapping("/prijava")
	public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
	    String korisnickoIme = credentials.get("korisnickoIme");
	    String lozinka = credentials.get("lozinka");

	    RegistrovaniKorisnik ulogovaniKorisnik = korisnikService.findByKorisnickoIme(korisnickoIme); 

	    if (ulogovaniKorisnik != null && passwordEncoder.matches(lozinka, ulogovaniKorisnik.getLozinka()) && ulogovaniKorisnik.isAktivan()) { 
	        UserDetails userDetails = userDetailsService.loadUserByUsername(ulogovaniKorisnik.getKorisnickoIme());
	        String token = tokenUtils.generateToken(userDetails, ulogovaniKorisnik); 
	        
	        Map<String, String> response = new HashMap<>();
	        response.put("token", token);
	        
	        return ResponseEntity.ok(response);
	    }
	    return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Map<String, String>> updateKorisnik(@PathVariable Long id, @RequestBody RegistrovaniKorisnikDTO dto) {
		RegistrovaniKorisnik postojeciKorisnik = korisnikService.findById(id);
		
		if (postojeciKorisnik == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		if (!dto.getKorisnickoIme().equals(postojeciKorisnik.getKorisnickoIme()) && !dto.getKorisnickoIme().isEmpty()) {
			postojeciKorisnik.setKorisnickoIme(dto.getKorisnickoIme());
		}
		
		if (!dto.getEmail().equals(postojeciKorisnik.getEmail()) && !dto.getEmail().isEmpty()) {
			postojeciKorisnik.setEmail(dto.getEmail());
		}

		if (!dto.getLozinka().isEmpty()) {
			postojeciKorisnik.setLozinka(passwordEncoder.encode(dto.getLozinka()));
		}
		
		RegistrovaniKorisnik azuriraniKorisnik = korisnikService.save(postojeciKorisnik);
		korisnikMapper.mapToDTO(azuriraniKorisnik);
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(azuriraniKorisnik.getKorisnickoIme());
		String token = tokenUtils.generateToken(userDetails, azuriraniKorisnik);
		Map<String, String> response = new HashMap<>();
		response.put("token", token);
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/registracija")
	public ResponseEntity<RegistrovaniKorisnikDTO> register(@RequestBody RegistrovaniKorisnikDTO dto) {
		if (korisnikService.postojiKorisnikSaKorisnickimImenom(dto.getKorisnickoIme())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
		
		if (korisnikService.postojiKorisnikSaEmailom(dto.getEmail())) {
	 		return new ResponseEntity<>(HttpStatus.CONFLICT);
	 	}
		
		RegistrovaniKorisnik korisnik = korisnikMapper.mapToEntity(dto);
		korisnik.setLozinka(passwordEncoder.encode(dto.getLozinka()));
		korisnikService.save(korisnik);
		
		return ResponseEntity.ok(korisnikMapper.mapToDTO(korisnik));
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/aktiviraj/{id}")
	public ResponseEntity<RegistrovaniKorisnik> activate(@PathVariable Long id) {
		RegistrovaniKorisnik korisnik = korisnikService.findById(id);
		
		if (korisnik != null) {
			korisnik.setAktivan(true);
		}
		
		return new ResponseEntity<>(korisnikService.save(korisnik), HttpStatus.OK);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return super.delete(id);
	}
}
