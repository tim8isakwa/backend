package com.univerzitet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.model.RegistrovaniKorisnik;
import com.univerzitet.app.repo.RegistrovaniKorisnikRepo;

@Service
public class RegistrovaniKorisnikService extends GenericService<RegistrovaniKorisnik, Long> {

	private final RegistrovaniKorisnikRepo repository;
	
	public RegistrovaniKorisnikService(RegistrovaniKorisnikRepo repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public RegistrovaniKorisnik save(RegistrovaniKorisnik t) {
		return super.save(t);
	}

	@Override
	public RegistrovaniKorisnik findById(Long id) {
		return super.findById(id);
	}

	@Override
	public List<RegistrovaniKorisnik> findAll() {
		return super.findAll();
	}

	public RegistrovaniKorisnik findByKorisnickoIme(String korisnickoIme) {
		return this.repository.findByKorisnickoIme(korisnickoIme);
	}
	
	public boolean postojiKorisnikSaKorisnickimImenom(String korisnickoIme) {
		return this.repository.existsByKorisnickoIme(korisnickoIme);
	}
	
	public boolean postojiKorisnikSaEmailom(String email) {
		return this.repository.existsByEmail(email);
	}
	
	@Override
	public RegistrovaniKorisnik update(RegistrovaniKorisnik t, Long id) {
		return super.update(t, id);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}
}

