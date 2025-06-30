package com.univerzitet.app.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.AdresaDTO;
import com.univerzitet.app.dto.DodeljenoPravoPristupaDTO;
import com.univerzitet.app.dto.NastavnikDTO;
import com.univerzitet.app.dto.ZvanjeDTO;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Drzava;
import com.univerzitet.app.model.Mesto;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.NaucnaOblast;
import com.univerzitet.app.model.TipZvanja;
import com.univerzitet.app.model.Zvanje;

@Component
public class NastavnikMapper {

	@Autowired  
	private PasswordEncoder passwordEncoder;
	
	public Nastavnik mapToEntity(NastavnikDTO dto) {
		Nastavnik nastavnik = new Nastavnik();
		
		nastavnik.setId(dto.getId());
		nastavnik.setKorisnickoIme(dto.getKorisnickoIme());
		nastavnik.setLozinka(passwordEncoder.encode(dto.getLozinka()));
		nastavnik.setEmail(dto.getEmail());
		nastavnik.setAktivan(true);
		
		if (dto.getAdresa() != null) {
			nastavnik.setAdresa(mapAdresaToEntity(dto.getAdresa()));
		}
		
		return nastavnik;
	}
	
	public NastavnikDTO mapToDTO(Nastavnik nastavnik) {
		NastavnikDTO dto = new NastavnikDTO();
		
		dto.setId(nastavnik.getId());
		dto.setKorisnickoIme(nastavnik.getKorisnickoIme());
		dto.setEmail(nastavnik.getEmail());
		dto.setAktivan(dto.isAktivan());
		
		if (nastavnik.getAdresa() != null) {
			dto.setAdresa(mapAdresaToDTO(nastavnik.getAdresa()));
		}
		
		if (nastavnik.getZvanja() != null) {
            dto.setZvanja(nastavnik.getZvanja().stream()
                    .map(this::mapZvanjeToDTO)
                    .collect(Collectors.toSet()));
        }
		
		Set<DodeljenoPravoPristupaDTO> dodeljenaPrava = nastavnik.getDodeljenaPrava().stream()
				.map(pravoPristupa -> new DodeljenoPravoPristupaDTO(pravoPristupa.getId(), pravoPristupa.getPravoPristupa().getNaziv()))
				.collect(Collectors.toSet());
		
		dto.setDodeljenaPrava(dodeljenaPrava);
		
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
    
    private ZvanjeDTO mapZvanjeToDTO(Zvanje zvanje) {
        ZvanjeDTO dto = new ZvanjeDTO();
        dto.setId(zvanje.getId());
        dto.setDatumIzbora(zvanje.getDatumIzbora());
        dto.setDatumPrestanka(zvanje.getDatumPrestanka());

        if (zvanje.getTipZvanja() != null) {
            dto.setTipZvanja(zvanje.getTipZvanja().getNaziv());
        }
        
        if (zvanje.getNaucnaOblast() != null) {
            dto.setNaucnaOblast(zvanje.getNaucnaOblast().getNaziv());
        }
        
        return dto;
    }

    private Zvanje mapZvanjeToEntity(ZvanjeDTO dto) {
        Zvanje zvanje = new Zvanje();
        
        zvanje.setId(dto.getId());
        zvanje.setDatumIzbora(dto.getDatumIzbora());
        zvanje.setDatumPrestanka(dto.getDatumPrestanka());

        if (dto.getTipZvanja() != null) {
            TipZvanja tipZvanja = new TipZvanja();
            tipZvanja.setNaziv(dto.getTipZvanja());
            zvanje.setTipZvanja(tipZvanja);
        }
        
        if (dto.getNaucnaOblast() != null) {
            NaucnaOblast naucnaOblast = new NaucnaOblast();
            naucnaOblast.setNaziv(dto.getNaucnaOblast());
            zvanje.setNaucnaOblast(naucnaOblast);
        }
        
        if (dto.getNastavnik() != null && dto.getNastavnik().getId() != null) {
            Nastavnik nastavnik = new Nastavnik();
            nastavnik.setId(dto.getNastavnik().getId());
            zvanje.setNastavnik(nastavnik);
        }
        
        return zvanje;
    }
}
