package com.univerzitet.app.dto;

public class IshodDTO {

    private Long id;
    
    private String opis;
    
    private Long predmetId;  

    public IshodDTO() {
        super();
    }

    public IshodDTO(Long id, String opis, Long predmetId) {
        super();
        this.id = id;
        this.opis = opis;
        this.predmetId = predmetId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }
}
