package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Drzava;

@Repository
public interface DrzavaRepo extends Repo<Drzava, Long> {
	Optional<Drzava> findByNaziv(String naziv);
}
