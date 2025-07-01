package com.univerzitet.app.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.univerzitet.app.dto.ObavestenjeDTO;
import com.univerzitet.app.dto.StudentPredmetDTO;
import com.univerzitet.app.service.StudentService;
import com.univerzitet.app.generic.GenericController;
import com.univerzitet.app.model.Student;

@RestController
@RequestMapping("/api/studenti")
public class StudentController extends GenericController<Student> {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        super(studentService);
        this.studentService = studentService;
    }

    @GetMapping("/{id}/predmeti")
    public ResponseEntity<List<StudentPredmetDTO>> getPredmetiKojeSlusa(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getPredmetiKojeSlusa(id));
    }
    
    @GetMapping("/{id}/obavestenja")
    public ResponseEntity<List<ObavestenjeDTO>> getObavestenja(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getObavestenjaZaPredmete(id));
    }

}
