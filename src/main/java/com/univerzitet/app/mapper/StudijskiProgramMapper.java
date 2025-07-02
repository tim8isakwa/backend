package com.univerzitet.app.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.FakultetDTO;
import com.univerzitet.app.dto.NastavnikDTO;
import com.univerzitet.app.dto.StudijskiProgramDTO;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.StudijskiProgram;

@Component
public class StudijskiProgramMapper {

	public StudijskiProgramDTO mapToDTO(StudijskiProgram program) {
        StudijskiProgramDTO dto = new StudijskiProgramDTO();
        
        dto.setId(program.getId());
        dto.setNaziv(program.getNaziv());
        dto.setOpis(program.getOpis());

        if (program.getRukovodilac() != null) {
            dto.setRukovodilac(mapNastavnikToDTO(program.getRukovodilac()));
        }
        
        if (program.getFakultet() != null) {
            dto.setFakultet(mapFakultetToDTO(program.getFakultet()));
        }
        
        return dto;
	}
	
	 
	public StudijskiProgram mapToEntity(StudijskiProgramDTO dto) {
        StudijskiProgram program = new StudijskiProgram();
        
        program.setId(dto.getId());
        program.setNaziv(dto.getNaziv());
        program.setOpis(dto.getOpis());
        
        if (dto.getRukovodilac() != null) {
            program.setRukovodilac(mapNastavnikToEntity(dto.getRukovodilac()));
        }

        if (dto.getFakultet() != null) {
            program.setFakultet(mapFakultetToEntity(dto.getFakultet()));
        }
        
        return program;
    }

	private NastavnikDTO mapNastavnikToDTO(Nastavnik nastavnik) {
		NastavnikDTO dto = new NastavnikDTO();
		 
		dto.setId(nastavnik.getId());
		dto.setIme(nastavnik.getIme());
		 
		return dto;
	}
	 
	private Nastavnik mapNastavnikToEntity(NastavnikDTO dto) {
		Nastavnik nastavnik = new Nastavnik();
		
		nastavnik.setId(dto.getId());
        nastavnik.setIme(dto.getIme());
        
        return nastavnik;
    }
	    
    private FakultetDTO mapFakultetToDTO(Fakultet fakultet) {
        FakultetDTO dto = new FakultetDTO();
        
        dto.setId(fakultet.getId());
        dto.setNaziv(fakultet.getNaziv());
        
        return dto;
    }
	    
    private Fakultet mapFakultetToEntity(FakultetDTO dto) {
        Fakultet fakultet = new Fakultet();
        
        fakultet.setId(dto.getId());
        fakultet.setNaziv(dto.getNaziv());
        
        return fakultet;
    }	 
}
	
