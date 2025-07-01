package com.univerzitet.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.dto.PolaganjeDTO;
import com.univerzitet.app.mapper.PolaganjeMapper;
import com.univerzitet.app.model.PohadjanjePredmeta;
import com.univerzitet.app.model.Polaganje;
import com.univerzitet.app.repo.PohadjanjePredmetaRepository;
import com.univerzitet.app.repo.PolaganjeRepository;

@Service
public class PolaganjeService {

    @Autowired
    private PolaganjeRepository polaganjeRepo;

    @Autowired
    private PolaganjeMapper polaganjeMapper;
    
    @Autowired
    private PohadjanjePredmetaRepository pohadjanjePredmetaRepo;

    public List<PolaganjeDTO> getPolaganjaZaStudenta(Long studentId) {
        List<Polaganje> polaganja = polaganjeRepo.findByPohadjanjePredmeta_Student_Id(studentId);
        return polaganja.stream()
                .map(polaganjeMapper::toDTO)
                .collect(Collectors.toList());
    }
    
    public void prijaviIspit(Long studentId, Long predmetId) {
        PohadjanjePredmeta pohadjanje = pohadjanjePredmetaRepo
            .findByStudentIdAndPredmetId(studentId, predmetId)
            .orElseThrow(() -> new RuntimeException("Student ne pohadja predmet."));

        Polaganje polaganje = new Polaganje();
        polaganje.setPohadjanjePredmeta(pohadjanje);
        polaganje.setDatumPolaganja(LocalDateTime.now());
        polaganje.setBodovi(null);
        polaganje.setOcena(null);

        polaganjeRepo.save(polaganje);
    }
}
