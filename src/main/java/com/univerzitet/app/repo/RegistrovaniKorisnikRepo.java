package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.RegistrovaniKorisnik;

@Repository
public interface RegistrovaniKorisnikRepo extends Repo<RegistrovaniKorisnik, Long> {
	RegistrovaniKorisnik findByKorisnickoIme(String korisnickoIme);
	RegistrovaniKorisnik findByEmail(String email);
	boolean existsByKorisnickoIme(String korisnickoIme);
	boolean existsByEmail(String email);
}
