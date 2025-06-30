package com.univerzitet.app.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.AdresaDTO;
import com.univerzitet.app.dto.FakultetDTO;
import com.univerzitet.app.dto.NastavnikDTO;
import com.univerzitet.app.dto.StudijskiProgramDTO;
import com.univerzitet.app.dto.UniverzitetDTO;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Drzava;
import com.univerzitet.app.model.Fakultet;
import com.univerzitet.app.model.Mesto;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.StudijskiProgram;
import com.univerzitet.app.model.Univerzitet;

@Component
public class FakultetMapper {

	public FakultetDTO mapToDTO(Fakultet fakultet) {
		FakultetDTO dto = new FakultetDTO();
	
		dto.setId(fakultet.getId());
		dto.setNaziv(fakultet.getNaziv());
		dto.setOpis(fakultet.getOpis());
		
		if (fakultet.getAdresa() != null) {
			dto.setAdresa(mapAdresaToDTO(fakultet.getAdresa()));
		}
		
		if (fakultet.getDekan() != null) {
			dto.setDekan(mapNastavnikToDTO(fakultet.getDekan()));
		}
		
		if (fakultet.getProgrami() != null) {
            dto.setProgrami(fakultet.getProgrami().stream()
                    .map(FakultetMapper::mapStudijskiProgramToDTO)
                    .collect(Collectors.toSet()));
        }
		
		if (fakultet.getUniverzitet() != null) {
			dto.setUniverzitet(mapUniverzitetToDTO(fakultet.getUniverzitet()));
		}
		
		return dto;
	}
	
	public Fakultet mapToEntity(FakultetDTO dto) {
		Fakultet fakultet = new Fakultet();
		
		fakultet.setId(dto.getId());
		fakultet.setNaziv(dto.getNaziv());
		fakultet.setOpis(dto.getOpis());
		
		if (dto.getAdresa() != null) {
			fakultet.setAdresa(mapAdresaToEntity(dto.getAdresa()));
		}
		
		if (dto.getDekan() != null) {
			fakultet.setDekan(mapNastavnikToEntity(dto.getDekan()));
		}
		
		if (dto.getProgrami() != null) {
            fakultet.setProgrami(dto.getProgrami().stream()
                    .map(FakultetMapper::mapStudijskiProgramToEntity)
                    .collect(Collectors.toSet()));
        }
		
		if (dto.getUniverzitet() != null) {
            fakultet.setUniverzitet(mapUniverzitetToEntity(dto.getUniverzitet()));
		}
		
		return fakultet;
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
    
	private static NastavnikDTO mapNastavnikToDTO(Nastavnik nastavnik) {
		NastavnikDTO dto = new NastavnikDTO();
		
		dto.setId(nastavnik.getId());
		dto.setIme(nastavnik.getIme());
		
		return dto;
	}
	
	private static Nastavnik mapNastavnikToEntity(NastavnikDTO dto) {
		Nastavnik nastavnik = new Nastavnik();
        
		nastavnik.setId(dto.getId());
        nastavnik.setIme(dto.getIme());
        
        return nastavnik;
	}
	
	private static StudijskiProgramDTO mapStudijskiProgramToDTO(StudijskiProgram program) {
		StudijskiProgramDTO dto = new StudijskiProgramDTO();
		
        dto.setId(program.getId());
        dto.setNaziv(program.getNaziv());
	
        return dto;
	}
	
	private static StudijskiProgram mapStudijskiProgramToEntity(StudijskiProgramDTO dto) {
		StudijskiProgram program = new StudijskiProgram();
		
		program.setId(dto.getId());
        program.setNaziv(dto.getNaziv());
		return program;
	}
	private static UniverzitetDTO mapUniverzitetToDTO(Univerzitet univerzitet) { 
        UniverzitetDTO dto = new UniverzitetDTO();
        
        dto.setId(univerzitet.getId());
        dto.setNaziv(univerzitet.getNaziv());
       
        return dto;
    }
        
    private static Univerzitet mapUniverzitetToEntity(UniverzitetDTO dto) {
		Univerzitet univerzitet = new Univerzitet();
	
		univerzitet.setId(dto.getId());
        univerzitet.setNaziv(dto.getNaziv());
        
		return univerzitet;
    }
}
