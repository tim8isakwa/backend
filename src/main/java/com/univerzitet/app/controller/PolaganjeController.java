package com.univerzitet.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.univerzitet.app.dto.PolaganjeDTO;
import com.univerzitet.app.service.PolaganjeService;

@RestController
@RequestMapping("/api/polaganja")
public class PolaganjeController {

    @Autowired
    private PolaganjeService polaganjeService;

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<PolaganjeDTO>> getPolaganjaZaStudenta(@PathVariable Long studentId) {
        return ResponseEntity.ok(polaganjeService.getPolaganjaZaStudenta(studentId));
    }
    
    @PostMapping("/student/{studentId}/prijava/{predmetId}")
    public ResponseEntity<String> prijaviIspit(@PathVariable Long studentId, @PathVariable Long predmetId) {
        polaganjeService.prijaviIspit(studentId, predmetId);
        return ResponseEntity.ok("Ispit uspešno prijavljen.");
    }

}
