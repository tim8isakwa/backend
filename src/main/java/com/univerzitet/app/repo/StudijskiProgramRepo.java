package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.StudijskiProgram;

@Repository
public interface StudijskiProgramRepo extends Repo<StudijskiProgram, Long>{
	StudijskiProgram findByNaziv(String naziv);
	boolean existsById(Long id);
}
