package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.PravoPristupa;

@Repository
public interface PravoPristupaRepo extends Repo<PravoPristupa, Long>{
	PravoPristupa findByNaziv(String naziv);
}
