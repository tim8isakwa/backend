package com.univerzitet.app.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.DodeljenoPravoPristupaDTO;
import com.univerzitet.app.dto.RegistrovaniKorisnikDTO;
import com.univerzitet.app.model.RegistrovaniKorisnik;

@Component
public class RegistrovaniKorisnikMapper {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public RegistrovaniKorisnik mapToEntity(RegistrovaniKorisnikDTO dto) {
		RegistrovaniKorisnik korisnik = new RegistrovaniKorisnik();
		
		korisnik.setId(dto.getId());
		korisnik.setKorisnickoIme(dto.getKorisnickoIme());
		korisnik.setLozinka(passwordEncoder.encode(dto.getLozinka()));
		korisnik.setEmail(dto.getEmail());
		korisnik.setAktivan(false);
		
		return korisnik;
	}
	
	public RegistrovaniKorisnikDTO mapToDTO(RegistrovaniKorisnik korisnik) {
		RegistrovaniKorisnikDTO dto = new RegistrovaniKorisnikDTO();
		
		dto.setId(korisnik.getId());
		dto.setKorisnickoIme(korisnik.getKorisnickoIme());
		dto.setEmail(korisnik.getEmail());
		dto.setAktivan(korisnik.isAktivan());
		Set<DodeljenoPravoPristupaDTO> dodeljenaPrava = korisnik.getDodeljenaPrava().stream()
				.map(pravoPristupa -> new DodeljenoPravoPristupaDTO(pravoPristupa.getId(), pravoPristupa.getPravoPristupa().getNaziv()))
				.collect(Collectors.toSet());
		
		dto.setDodeljenaPrava(dodeljenaPrava);
		
		return dto;
	}
}
