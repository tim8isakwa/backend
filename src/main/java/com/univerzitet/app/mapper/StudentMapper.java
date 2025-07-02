package com.univerzitet.app.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.AdresaDTO;
import com.univerzitet.app.dto.DodeljenoPravoPristupaDTO;
import com.univerzitet.app.dto.PohadjanjePredmetaDTO;
import com.univerzitet.app.dto.StudentDTO;
import com.univerzitet.app.dto.StudentNaGodiniDTO;
import com.univerzitet.app.dto.StudentPredmetDTO;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.DodeljenoPravoPristupa;
import com.univerzitet.app.model.Drzava;
import com.univerzitet.app.model.Mesto;
import com.univerzitet.app.model.PohadjanjePredmeta;
import com.univerzitet.app.model.Student;
import com.univerzitet.app.model.StudentNaGodini;

@Component
public class StudentMapper {

    @Autowired  
    private PasswordEncoder passwordEncoder;

    public Student mapToEntity(StudentDTO dto) {
        Student student = new Student();

        student.setJmbg(dto.getJmbg());
        student.setIme(dto.getIme());

        if (dto.getAdresa() != null) {
            student.setAdresa(mapAdresaToEntity(dto.getAdresa()));
        }

        if (dto.getStudentNaGodinima() != null) {
            student.setStudentNaGodinima(dto.getStudentNaGodinima().stream()
                    .map(this::mapStudentNaGodiniToEntity)
                    .collect(Collectors.toSet()));
        }

        if (dto.getPohadjanjePredmeta() != null) {
            student.setPohadjanjePredmeta(dto.getPohadjanjePredmeta().stream()
                    .map(this::mapPohadjanjePredmetaToEntity)
                    .collect(Collectors.toSet()));
        }

        return student;
    }

    public StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();

        dto.setId(student.getId());
        dto.setJmbg(student.getJmbg());
        dto.setIme(student.getIme());
        dto.setEmail(student.getEmail());
        dto.setKorisnickoIme(student.getKorisnickoIme());
        dto.setAktivan(student.isAktivan());

        if (student.getDodeljenaPrava() != null) {
            Set<DodeljenoPravoPristupaDTO> dodeljenaPrava = student.getDodeljenaPrava().stream()
                    .map(pravoPristupa -> new DodeljenoPravoPristupaDTO(
                            pravoPristupa.getId(),
                            pravoPristupa.getPravoPristupa().getNaziv()))
                    .collect(Collectors.toSet());
            dto.setDodeljenaPrava(dodeljenaPrava);
        }

        if (student.getAdresa() != null) {
            dto.setAdresa(mapAdresaToDTO(student.getAdresa()));
        }

        if (student.getStudentNaGodinima() != null) {
            dto.setStudentNaGodinima(student.getStudentNaGodinima().stream()
                    .map(this::mapStudentNaGodiniToDTO)
                    .collect(Collectors.toSet()));
        }

        if (student.getPohadjanjePredmeta() != null) {
            dto.setPohadjanjePredmeta(student.getPohadjanjePredmeta().stream()
                    .map(this::mapPohadjanjePredmetaToDTO)
                    .collect(Collectors.toSet()));
        }

        return dto;
    }

    private static AdresaDTO mapAdresaToDTO(Adresa adresa) {
        AdresaDTO dto = new AdresaDTO();

        dto.setId(adresa.getId());
        dto.setUlica(adresa.getUlica());
        dto.setBroj(adresa.getBroj());

        if (adresa.getMesto() != null) {
            dto.setMesto(adresa.getMesto().getNaziv());

            if (adresa.getMesto().getDrzava() != null) {
                dto.setDrzava(adresa.getMesto().getDrzava().getNaziv());
            }
        }

        return dto;
    }

    private static Adresa mapAdresaToEntity(AdresaDTO dto) {
        Adresa adresa = new Adresa();

        adresa.setUlica(dto.getUlica());
        adresa.setBroj(dto.getBroj());

        if (dto.getMesto() != null) {
            Mesto mesto = new Mesto();
            mesto.setNaziv(dto.getMesto());

            if (dto.getDrzava() != null) {
                Drzava drzava = new Drzava();
                drzava.setNaziv(dto.getDrzava());
                mesto.setDrzava(drzava);
            }

            adresa.setMesto(mesto);
        }

        return adresa;
    }

    
    private StudentNaGodiniDTO mapStudentNaGodiniToDTO(StudentNaGodini studentNaGodini) {
        StudentNaGodiniDTO dto = new StudentNaGodiniDTO();
        dto.setId(studentNaGodini.getId());
        return dto;
    }

    private StudentNaGodini mapStudentNaGodiniToEntity(StudentNaGodiniDTO dto) {
        StudentNaGodini studentNaGodini = new StudentNaGodini();
        studentNaGodini.setId(dto.getId());
        return studentNaGodini;
    }

    
    private PohadjanjePredmetaDTO mapPohadjanjePredmetaToDTO(PohadjanjePredmeta pohadjanjePredmeta) {
        PohadjanjePredmetaDTO dto = new PohadjanjePredmetaDTO();
        dto.setId(pohadjanjePredmeta.getId());
        return dto;
    }

    private PohadjanjePredmeta mapPohadjanjePredmetaToEntity(PohadjanjePredmetaDTO dto) {
        PohadjanjePredmeta pohadjanjePredmeta = new PohadjanjePredmeta();
        pohadjanjePredmeta.setId(dto.getId());
        return pohadjanjePredmeta;
    }

    
    public List<StudentPredmetDTO> mapPohadjanjaToDTO(Set<PohadjanjePredmeta> pohadjanja) {
        return pohadjanja.stream()
            .flatMap(p -> p.getRealizacijaPredmeta().getPredmeti().stream().map(predmet ->
                new StudentPredmetDTO(
                    predmet.getId(),
                    predmet.getNaziv(),
                    predmet.getEspb().intValue(),
                    p.getRealizacijaPredmeta().getId()
                )
            ))
            .collect(Collectors.toList());
    }
}
