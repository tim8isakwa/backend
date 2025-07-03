package com.univerzitet.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univerzitet.app.model.Obavestenje;

public interface ObavestenjeRepository extends JpaRepository<Obavestenje, Long> {

    List<Obavestenje> findByRealizacijaPredmetaId(Long realizacijaId);
}
