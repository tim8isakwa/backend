package com.univerzitet.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.univerzitet.app.model.PohadjanjePredmeta;

public interface PohadjanjePredmetaRepository extends JpaRepository<PohadjanjePredmeta, Long> {
//Traži PohadjanjePredmeta gde:student id odgovara, predmetId je u setu predmeta te realizacije
    @Query("SELECT pp FROM PohadjanjePredmeta pp " +
           "WHERE pp.student.id = :studentId " +
           "AND :predmetId IN (SELECT p.id FROM RealizacijaPredmeta rp JOIN rp.predmeti p WHERE rp = pp.realizacijaPredmeta)")
    Optional<PohadjanjePredmeta> findByStudentIdAndPredmetId(@Param("studentId") Long studentId,
                                                             @Param("predmetId") Long predmetId);
}
