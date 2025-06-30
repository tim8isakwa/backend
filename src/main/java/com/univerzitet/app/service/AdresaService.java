package com.univerzitet.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univerzitet.app.dto.AdresaDTO;
import com.univerzitet.app.generic.GenericService;
import com.univerzitet.app.generic.Repo;
import com.univerzitet.app.model.Adresa;
import com.univerzitet.app.model.Drzava;
import com.univerzitet.app.model.Mesto;
import com.univerzitet.app.repo.AdresaRepo;
import com.univerzitet.app.repo.DrzavaRepo;
import com.univerzitet.app.repo.MestoRepo;

@Service
public class AdresaService extends GenericService<Adresa, Long> {

    private MestoRepo mestoRepo;
    private DrzavaRepo drzavaRepo;

    @Autowired
    public AdresaService(Repo<Adresa, Long> repository, MestoRepo mestoRepo, DrzavaRepo drzavaRepo) {
        super(repository);
        this.mestoRepo = mestoRepo;
        this.drzavaRepo = drzavaRepo;
    }

    public Adresa save(AdresaDTO dto) {
        Drzava drzava = drzavaRepo.findByNaziv(dto.getDrzava())
                .orElseGet(() -> {
                    Drzava novaDrzava = new Drzava();
                    novaDrzava.setNaziv(dto.getDrzava());
                    return drzavaRepo.save(novaDrzava);
                });

        Mesto mesto = mestoRepo.findByNazivAndDrzava(dto.getMesto(), drzava)
                .orElseGet(() -> {
                    Mesto novoMesto = new Mesto();
                    novoMesto.setNaziv(dto.getMesto());
                    novoMesto.setDrzava(drzava);
                    drzava.getMesta().add(novoMesto);
                    return mestoRepo.save(novoMesto);
                });

        Adresa adresa;

        if (dto.getId() != null) {
            adresa = this.findById(dto.getId());

            adresa.setBroj(dto.getBroj());  
            adresa.setUlica(dto.getUlica());
            adresa.setMesto(mesto);

            return this.save(adresa);
        } else {
            adresa = findByBrojAndUlicaAndMesto(dto.getBroj(), dto.getUlica(), mesto)
                    .orElseGet(() -> {
                        Adresa novaAdresa = new Adresa();
                        novaAdresa.setBroj(dto.getBroj());
                        novaAdresa.setUlica(dto.getUlica());
                        novaAdresa.setMesto(mesto);
                        return novaAdresa;  
                    });

            return this.save(adresa);
        }
    }

    private Optional<Adresa> findByBrojAndUlicaAndMesto(String broj, String ulica, Mesto mesto) {
        return this.findByBrojAndUlicaAndMesto(broj, ulica, mesto);
    }
}
