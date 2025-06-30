package com.univerzitet.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.dto.ZvanjeDTO;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Nastavnik;
import com.univerzitet.app.model.NaucnaOblast;
import com.univerzitet.app.model.TipZvanja;
import com.univerzitet.app.model.Zvanje;
import com.univerzitet.app.repo.NastavnikRepo;
import com.univerzitet.app.repo.NaucnaOblastRepo;
import com.univerzitet.app.repo.TipZvanjaRepo;

@Service
public class ZvanjeService extends GenericService<Zvanje, Long>{

	private TipZvanjaRepo tipZvanjaRepo;
	
	private NaucnaOblastRepo naucnaOblastRepo;
	
	private NastavnikRepo nastavnikRepo;

	@Autowired
	public ZvanjeService(Repo<Zvanje, Long> repository, TipZvanjaRepo tipZvanjaRepo, NaucnaOblastRepo naucnaOblastRepo,
			NastavnikRepo nastavnikRepo) {
		super(repository);
		this.tipZvanjaRepo = tipZvanjaRepo;
		this.naucnaOblastRepo = naucnaOblastRepo;
		this.nastavnikRepo = nastavnikRepo;
	}
	
	public Zvanje save(ZvanjeDTO dto) {
        TipZvanja tipZvanja = tipZvanjaRepo.findByNaziv(dto.getTipZvanja())
                .orElseGet(() -> {
                    TipZvanja noviTipZvanja = new TipZvanja();
                    noviTipZvanja.setNaziv(dto.getTipZvanja());
                    return tipZvanjaRepo.save(noviTipZvanja);
                });

        NaucnaOblast naucnaOblast = naucnaOblastRepo.findByNaziv(dto.getNaucnaOblast())
                .orElseGet(() -> {
                    NaucnaOblast novaNaucnaOblast = new NaucnaOblast();
                    novaNaucnaOblast.setNaziv(dto.getNaucnaOblast());
                    return naucnaOblastRepo.save(novaNaucnaOblast);
                });

        Nastavnik nastavnik = nastavnikRepo.findById(dto.getNastavnik().getId())
                .orElse(null);
        
        Zvanje zvanje;

        if (dto.getId() != null) {
            zvanje = this.findById(dto.getId());
            zvanje.setDatumIzbora(dto.getDatumIzbora());
            zvanje.setDatumPrestanka(dto.getDatumPrestanka());
            zvanje.setTipZvanja(tipZvanja);
            zvanje.setNaucnaOblast(naucnaOblast);
            zvanje.setNastavnik(nastavnik);

            return this.save(zvanje);
        } else {
            Zvanje novoZvanje = new Zvanje();
            novoZvanje.setDatumIzbora(dto.getDatumIzbora());
            novoZvanje.setDatumPrestanka(dto.getDatumPrestanka());
            novoZvanje.setTipZvanja(tipZvanja);
            novoZvanje.setNaucnaOblast(naucnaOblast);
            novoZvanje.setNastavnik(nastavnik);
            
            return this.save(novoZvanje);
        }
    }
}
