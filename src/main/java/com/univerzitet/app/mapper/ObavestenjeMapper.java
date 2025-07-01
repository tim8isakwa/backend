package com.univerzitet.app.mapper;

import org.springframework.stereotype.Component;
import com.univerzitet.app.dto.ObavestenjeDTO;
import com.univerzitet.app.model.Obavestenje;

@Component
public class ObavestenjeMapper {

    public ObavestenjeDTO toDTO(Obavestenje o) {
        ObavestenjeDTO dto = new ObavestenjeDTO();
        dto.setId(o.getId());
        dto.setSadrzaj(o.getSadrzaj());
        dto.setDatumPostavljanja(o.getDatumPostavljanja());
        dto.setRealizacijaPredmetaId(o.getRealizacijaPredmeta().getId());
        return dto;
    }
}
