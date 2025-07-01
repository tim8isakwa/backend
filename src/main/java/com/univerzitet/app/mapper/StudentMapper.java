package com.univerzitet.app.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.StudentPredmetDTO;
import com.univerzitet.app.model.PohadjanjePredmeta;

@Component
public class StudentMapper {

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
