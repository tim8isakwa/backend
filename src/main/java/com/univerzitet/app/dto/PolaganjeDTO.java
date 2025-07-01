package com.univerzitet.app.dto;

import java.time.LocalDateTime;

public class PolaganjeDTO {

    private Long id;
    private Long predmetId;
    private String predmetNaziv;
    private LocalDateTime datumPolaganja;
    private Integer bodovi;
    private Integer ocena;

    public PolaganjeDTO() {}

    public PolaganjeDTO(Long id, Long predmetId, String predmetNaziv, LocalDateTime datumPolaganja, Integer bodovi, Integer ocena) {
        this.id = id;
        this.predmetId = predmetId;
        this.predmetNaziv = predmetNaziv;
        this.datumPolaganja = datumPolaganja;
        this.bodovi = bodovi;
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getPredmetNaziv() {
        return predmetNaziv;
    }

    public void setPredmetNaziv(String predmetNaziv) {
        this.predmetNaziv = predmetNaziv;
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
}
