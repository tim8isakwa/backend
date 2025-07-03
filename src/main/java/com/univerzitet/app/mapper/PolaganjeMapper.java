package com.univerzitet.app.mapper;

import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.PolaganjeDTO;
import com.univerzitet.app.model.Polaganje;
import com.univerzitet.app.model.Predmet;

@Component
public class PolaganjeMapper {

    public PolaganjeDTO toDTO(Polaganje p) {
        Predmet predmet = p.getPohadjanjePredmeta().getRealizacijaPredmeta().getPredmeti().iterator().next(); // ako ima više predmeta

        PolaganjeDTO dto = new PolaganjeDTO();
        dto.setId(p.getId());
        dto.setDatumPolaganja(p.getDatumPolaganja());
        dto.setBodovi(p.getBodovi());
        dto.setOcena(p.getOcena());
        dto.setPredmetId(predmet.getId());
        dto.setPredmetNaziv(predmet.getNaziv());
        return dto;
    }
}
