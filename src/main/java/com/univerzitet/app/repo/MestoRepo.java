package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Drzava;
import com.univerzitet.app.model.Mesto;

@Repository
public interface MestoRepo extends Repo<Mesto, Long>{
	Optional<Mesto> findByNazivAndDrzava(String naziv, Drzava drzava);
}
