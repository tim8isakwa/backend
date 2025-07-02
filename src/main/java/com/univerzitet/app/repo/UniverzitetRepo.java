package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Univerzitet;

@Repository
public interface UniverzitetRepo extends Repo<Univerzitet, Long>{
	boolean existsById(Long id);
}
