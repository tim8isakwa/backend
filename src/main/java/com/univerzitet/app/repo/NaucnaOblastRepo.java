package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.NaucnaOblast;

@Repository
public interface NaucnaOblastRepo extends Repo<NaucnaOblast, Long>{
	Optional<NaucnaOblast> findByNaziv(String naziv);
}
