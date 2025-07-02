package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.TipZvanja;

@Repository
public interface TipZvanjaRepo extends Repo<TipZvanja, Long> {
	Optional<TipZvanja> findByNaziv(String naziv);
}
