package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Mesto;

@Repository
public interface AdresaRepo extends Repo<Adresa, Long>{
    Optional<Adresa> findByBrojAndUlicaAndMesto(String broj, String ulica, Mesto mesto);
}

