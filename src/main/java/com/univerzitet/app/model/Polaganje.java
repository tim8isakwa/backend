package com.univerzitet.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Polaganje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime datumPolaganja;

    private Integer bodovi;

    private Integer ocena;

    @ManyToOne
    private PohadjanjePredmeta pohadjanjePredmeta;

    public Polaganje() {}

    public Polaganje(Long id, LocalDateTime datumPolaganja, Integer bodovi, Integer ocena, PohadjanjePredmeta pohadjanjePredmeta) {
        this.id = id;
        this.datumPolaganja = datumPolaganja;
        this.bodovi = bodovi;
        this.ocena = ocena;
        this.pohadjanjePredmeta = pohadjanjePredmeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(LocalDateTime datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    public Integer getBodovi() {
        return bodovi;
    }

    public void setBodovi(Integer bodovi) {
        this.bodovi = bodovi;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public PohadjanjePredmeta getPohadjanjePredmeta() {
        return pohadjanjePredmeta;
    }

    public void setPohadjanjePredmeta(PohadjanjePredmeta pohadjanjePredmeta) {
        this.pohadjanjePredmeta = pohadjanjePredmeta;
    }
}
