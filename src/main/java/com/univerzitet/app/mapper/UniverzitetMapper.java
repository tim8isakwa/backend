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
public class UniverzitetMapper {

    public UniverzitetDTO mapToDTO(Univerzitet univerzitet) {
    	UniverzitetDTO dto = new UniverzitetDTO();
    	
    	dto.setId(univerzitet.getId());
        dto.setNaziv(univerzitet.getNaziv());
        dto.setDatumOsnivanja(univerzitet.getDatumOsnivanja());
        dto.setOpis(univerzitet.getOpis());
        
        if (univerzitet.getAdresa() != null) {
            dto.setAdresa(mapAdresaToDTO(univerzitet.getAdresa()));
        }
        
        if (univerzitet.getRektor() != null) {
            dto.setRektor(mapNastavnikToDTO(univerzitet.getRektor()));
        }
        
        if (univerzitet.getFakulteti() != null) {
            dto.setFakulteti(univerzitet.getFakulteti().stream()
                    .map(this::mapFakultetToDTO)
                    .collect(Collectors.toSet()));
        }
        
        return dto;
    }

    public Univerzitet mapToEntity(UniverzitetDTO dto) { 
    	Univerzitet univerzitet = new Univerzitet();
    	
    	univerzitet.setId(dto.getId());
        univerzitet.setNaziv(dto.getNaziv());
        univerzitet.setDatumOsnivanja(dto.getDatumOsnivanja());
        univerzitet.setOpis(dto.getOpis());
        
        if (dto.getAdresa() != null) {
            univerzitet.setAdresa(mapAdresaToEntity(dto.getAdresa()));
        }
        
        if (dto.getRektor() != null) {
            univerzitet.setRektor(mapNastavnikToEntity(dto.getRektor()));
        }
        
        if (dto.getFakulteti() != null) {
            univerzitet.setFakulteti(dto.getFakulteti().stream()
                    .map(this::mapFakultetToEntity)
                    .collect(Collectors.toSet()));
        }
        
    	return univerzitet;
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
        
        if (fakultet.getProgrami() != null) {
            dto.setProgrami(fakultet.getProgrami().stream()
                    .map(UniverzitetMapper::mapStudijskiProgramToDTO)
                    .collect(Collectors.toSet()));
        }
        
        return dto;
    }
    
    private Fakultet mapFakultetToEntity(FakultetDTO dto) {
        Fakultet fakultet = new Fakultet();
        
        fakultet.setId(dto.getId());
        fakultet.setNaziv(dto.getNaziv());
        
        if (dto.getProgrami() != null) {
            fakultet.setProgrami(dto.getProgrami().stream()
                    .map(UniverzitetMapper::mapStudijskiProgramToEntity)
                    .collect(Collectors.toSet()));
        }
        
        return fakultet;

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
}

