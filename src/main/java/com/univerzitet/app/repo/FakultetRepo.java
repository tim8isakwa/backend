package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Fakultet;

@Repository
public interface FakultetRepo extends Repo<Fakultet, Long>{
	Fakultet findByNaziv(String naziv);
}
