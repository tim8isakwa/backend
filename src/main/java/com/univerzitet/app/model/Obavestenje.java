package com.univerzitet.app.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
public class Obavestenje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sadrzaj;

    private LocalDateTime datumPostavljanja;

    @ManyToOne
    private RealizacijaPredmeta realizacijaPredmeta;

    public Obavestenje() {}

    public Obavestenje(Long id, String sadrzaj, LocalDateTime datumPostavljanja, RealizacijaPredmeta realizacijaPredmeta) {
        this.id = id;
        this.sadrzaj = sadrzaj;
        this.datumPostavljanja = datumPostavljanja;
        this.realizacijaPredmeta = realizacijaPredmeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public LocalDateTime getDatumPostavljanja() {
        return datumPostavljanja;
    }

    public void setDatumPostavljanja(LocalDateTime datumPostavljanja) {
        this.datumPostavljanja = datumPostavljanja;
    }

    public RealizacijaPredmeta getRealizacijaPredmeta() {
        return realizacijaPredmeta;
    }

    public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
        this.realizacijaPredmeta = realizacijaPredmeta;
    }
}
