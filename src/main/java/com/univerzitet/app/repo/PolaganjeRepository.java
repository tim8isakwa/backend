package com.univerzitet.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.univerzitet.app.model.Polaganje;

public interface PolaganjeRepository extends JpaRepository<Polaganje, Long> {
    List<Polaganje> findByPohadjanjePredmeta_Student_Id(Long studentId);
}
