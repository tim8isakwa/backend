package com.univerzitet.app.dto;

import java.util.Set;

public class RealizacijaPredmetaDTO {

    private Long id;
    
    private Set<PredmetDTO> predmeti;
    
    private Set<NastavnikNaRealizacijiDTO> nastavnikNaRealizaciji;

    public RealizacijaPredmetaDTO() {
        super();
    }

    public RealizacijaPredmetaDTO(Long id, Set<PredmetDTO> predmeti, Set<NastavnikNaRealizacijiDTO> nastavnikNaRealizaciji) {
        super();
        this.id = id;
        this.predmeti = predmeti;
        this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<PredmetDTO> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(Set<PredmetDTO> predmeti) {
        this.predmeti = predmeti;
    }

    public Set<NastavnikNaRealizacijiDTO> getNastavnikNaRealizaciji() {
        return nastavnikNaRealizaciji;
    }

    public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizacijiDTO> nastavnikNaRealizaciji) {
        this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
    }
}
