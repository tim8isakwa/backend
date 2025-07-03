package com.univerzitet.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.univerzitet.app.dto.ObavestenjeDTO;
import com.univerzitet.app.dto.StudentPredmetDTO;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.mapper.ObavestenjeMapper;
import com.univerzitet.app.mapper.StudentMapper;
import com.univerzitet.app.model.Obavestenje;
import com.univerzitet.app.model.Student;
import com.univerzitet.app.repo.ObavestenjeRepository;
import com.univerzitet.app.repo.StudentRepository;

@Service
public class StudentService extends GenericService<Student, Long> {

    private final StudentRepository studentRepo;
    private final StudentMapper studentMapper;
    private final ObavestenjeRepository obavestenjeRepo;
    private final ObavestenjeMapper obavestenjeMapper;

    public StudentService(Repo<Student, Long> repository,
                          StudentRepository studentRepo,
                          StudentMapper studentMapper,
                          ObavestenjeRepository obavestenjeRepo,
                          ObavestenjeMapper obavestenjeMapper) {
        super(repository);
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
        this.obavestenjeRepo = obavestenjeRepo;
        this.obavestenjeMapper = obavestenjeMapper;
    }

    public List<StudentPredmetDTO> getPredmetiKojeSlusa(Long studentId) {
        Student student = studentRepo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student ne postoji"));

        return studentMapper.mapPohadjanjaToDTO(student.getPohadjanjePredmeta());
    }

    public List<ObavestenjeDTO> getObavestenjaZaPredmete(Long studentId) {
        Student student = studentRepo.findById(studentId)
            .orElseThrow(() -> new RuntimeException("Student ne postoji"));

        List<Long> realizacijaIds = student.getPohadjanjePredmeta().stream()
            .map(p -> p.getRealizacijaPredmeta().getId())
            .toList();

        List<Obavestenje> obavestenja = obavestenjeRepo.findAll().stream()
            .filter(o -> realizacijaIds.contains(o.getRealizacijaPredmeta().getId()))
            .toList();

        return obavestenja.stream()
            .map(obavestenjeMapper::toDTO)
            .toList();
    }
}
