package com.univerzitet.app.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.RegistrovaniKorisnik;

@Repository
public interface RegistrovaniKorisnikRepo extends Repo<RegistrovaniKorisnik, Long> {
	RegistrovaniKorisnik findByKorisnickoIme(String korisnickoIme);
	RegistrovaniKorisnik findByEmail(String email);
	List<RegistrovaniKorisnik> findByAktivan(boolean aktivan);
	boolean existsByKorisnickoIme(String korisnickoIme);
	boolean existsByEmail(String email);
}
