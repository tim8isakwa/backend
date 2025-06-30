package com.univerzitet.app.dto;

import java.util.Set;

public class NastavnikNaRealizacijiDTO {

    private Long id;
    
    private Long brojCasova;

    private Set<NastavnikDTO> nastavnici;
    
    private Set<TipNastaveDTO> tipoviNastave;
    
    private RealizacijaPredmetaDTO realizacijaPredmeta;

    public NastavnikNaRealizacijiDTO() {
        super();
    }

    public NastavnikNaRealizacijiDTO(Long id, Long brojCasova, Set<NastavnikDTO> nastavnici,
                                     Set<TipNastaveDTO> tipoviNastave, RealizacijaPredmetaDTO realizacijaPredmeta) {
        super();
        this.id = id;
        this.brojCasova = brojCasova;
        this.nastavnici = nastavnici;
        this.tipoviNastave = tipoviNastave;
        this.realizacijaPredmeta = realizacijaPredmeta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrojCasova() {
        return brojCasova;
    }

    public void setBrojCasova(Long brojCasova) {
        this.brojCasova = brojCasova;
    }

    public Set<NastavnikDTO> getNastavnici() {
        return nastavnici;
    }

    public void setNastavnici(Set<NastavnikDTO> nastavnici) {
        this.nastavnici = nastavnici;
    }

    public Set<TipNastaveDTO> getTipoviNastave() {
        return tipoviNastave;
    }

    public void setTipoviNastave(Set<TipNastaveDTO> tipoviNastave) {
        this.tipoviNastave = tipoviNastave;
    }

    public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
        return realizacijaPredmeta;
    }

    public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.realizacijaPredmeta = realizacijaPredmeta;
    }
}
