package com.univerzitet.app.dto;

public class TipNastaveDTO {

    private Long id;
    
    private String naziv;
    
    private Long nastavnikNaRealizacijiId;  

    public TipNastaveDTO() {
        super();
    }

    public TipNastaveDTO(Long id, String naziv, Long nastavnikNaRealizacijiId) {
        super();
        this.id = id;
        this.naziv = naziv;
        this.nastavnikNaRealizacijiId = nastavnikNaRealizacijiId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Long getNastavnikNaRealizacijiId() {
        return nastavnikNaRealizacijiId;
    }

    public void setNastavnikNaRealizacijiId(Long nastavnikNaRealizacijiId) {
        this.nastavnikNaRealizacijiId = nastavnikNaRealizacijiId;
    }
}
