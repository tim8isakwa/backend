package com.univerzitet.app.dto;

import java.util.Set;

public class PredmetDTO {

    private Long id;
    private String naziv;
    private Long espb;
    private boolean obavezan;
    private Long brojPredavanja;
    private Long brojVezbi;
    private Long drugiObliciNastave;
    private Long istrazivackiRad;
    private Long ostaliCasovi;

    private PredmetDTO preduslov;  
    private Set<IshodDTO> ishodi;
    private Set<GodinaStudijaDTO> godineStudija;
    private RealizacijaPredmetaDTO realizacijaPredmeta;

    public PredmetDTO() {
        super();
    }

    public PredmetDTO(Long id, String naziv, Long espb, boolean obavezan, Long brojPredavanja, Long brojVezbi,
                      Long drugiObliciNastave, Long istrazivackiRad, Long ostaliCasovi, PredmetDTO preduslov,
                      Set<IshodDTO> ishodi, Set<GodinaStudijaDTO> godineStudija, RealizacijaPredmetaDTO realizacijaPredmeta) {
        super();
        this.id = id;
        this.naziv = naziv;
        this.espb = espb;
        this.obavezan = obavezan;
        this.brojPredavanja = brojPredavanja;
        this.brojVezbi = brojVezbi;
        this.drugiObliciNastave = drugiObliciNastave;
        this.istrazivackiRad = istrazivackiRad;
        this.ostaliCasovi = ostaliCasovi;
        this.preduslov = preduslov;
        this.ishodi = ishodi;
        this.godineStudija = godineStudija;
        this.realizacijaPredmeta = realizacijaPredmeta;
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

    public Long getEspb() {
        return espb;
    }

    public void setEspb(Long espb) {
        this.espb = espb;
    }

    public boolean isObavezan() {
        return obavezan;
    }

    public void setObavezan(boolean obavezan) {
        this.obavezan = obavezan;
    }

    public Long getBrojPredavanja() {
        return brojPredavanja;
    }

    public void setBrojPredavanja(Long brojPredavanja) {
        this.brojPredavanja = brojPredavanja;
    }

    public Long getBrojVezbi() {
        return brojVezbi;
    }

    public void setBrojVezbi(Long brojVezbi) {
        this.brojVezbi = brojVezbi;
    }

    public Long getDrugiObliciNastave() {
        return drugiObliciNastave;
    }

    public void setDrugiObliciNastave(Long drugiObliciNastave) {
        this.drugiObliciNastave = drugiObliciNastave;
    }

    public Long getIstrazivackiRad() {
        return istrazivackiRad;
    }

    public void setIstrazivackiRad(Long istrazivackiRad) {
        this.istrazivackiRad = istrazivackiRad;
    }

    public Long getOstaliCasovi() {
        return ostaliCasovi;
    }

    public void setOstaliCasovi(Long ostaliCasovi) {
        this.ostaliCasovi = ostaliCasovi;
    }

    public PredmetDTO getPreduslov() {
        return preduslov;
    }

    public void setPreduslov(PredmetDTO preduslov) {
        this.preduslov = preduslov;
    }

    public Set<IshodDTO> getIshodi() {
        return ishodi;
    }

    public void setIshodi(Set<IshodDTO> ishodi) {
        this.ishodi = ishodi;
    }

    public Set<GodinaStudijaDTO> getGodineStudija() {
        return godineStudija;
    }

    public void setGodineStudija(Set<GodinaStudijaDTO> godineStudija) {
        this.godineStudija = godineStudija;
    }

    public RealizacijaPredmetaDTO getRealizacijaPredmeta() {
        return realizacijaPredmeta;
    }

    public void setRealizacijaPredmeta(RealizacijaPredmetaDTO realizacijaPredmeta) {
        this.realizacijaPredmeta = realizacijaPredmeta;
    }
}
