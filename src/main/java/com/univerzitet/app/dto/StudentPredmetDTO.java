package com.univerzitet.app.dto;

public class StudentPredmetDTO {
    private Long predmetId;
    private String naziv;
    private int espb;
    private Long realizacijaId;

    public StudentPredmetDTO() {}

    public StudentPredmetDTO(Long predmetId, String naziv, int espb, Long realizacijaId) {
        this.predmetId = predmetId;
        this.naziv = naziv;
        this.espb = espb;
        this.realizacijaId = realizacijaId;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public Long getRealizacijaId() {
        return realizacijaId;
    }

    public void setRealizacijaId(Long realizacijaId) {
        this.realizacijaId = realizacijaId;
    }
}
