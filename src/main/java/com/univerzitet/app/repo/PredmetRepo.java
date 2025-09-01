package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Predmet;

@Repository
public interface PredmetRepo extends Repo<Predmet, Long>{

}
