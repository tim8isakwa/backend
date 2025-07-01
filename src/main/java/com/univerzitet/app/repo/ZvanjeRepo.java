package com.univerzitet.app.repo;

import org.springframework.stereotype.Repository;

import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Zvanje;

@Repository
public interface ZvanjeRepo extends Repo<Zvanje, Long> {

}
