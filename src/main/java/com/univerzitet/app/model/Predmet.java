package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Predmet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@Column(nullable = false)
	private Long espb;
	
	@Column(nullable = false)
	private boolean obavezan;
	
	@Column(nullable = false)
	private Long brojPredavanja;
	
	@Column(nullable = false)
	private Long brojVezbi;
	
	@Column(nullable = false)
	private Long drugiObliciNastave;
	
	@Column(nullable = false)
	private Long istrazivackiRad;
	
	@Column(nullable = false)
	private Long ostaliCasovi;
	
	@ManyToOne
	@JoinColumn(name = "preduslov_id")
	private Predmet preduslov;

	@OneToMany(mappedBy = "predmet")
	private Set<Ishod> ishodi;
	
	@ManyToMany(mappedBy = "predmeti")
	private Set<GodinaStudija> godineStudija;
	
	@ManyToOne
	private RealizacijaPredmeta realizacijaPredmeta;

	public Predmet() {
		super();
	}

	public Predmet(Long id, String naziv, Long espb, boolean obavezan, Long brojPredavanja, Long brojVezbi,
			Long drugiObliciNastave, Long istrazivackiRad, Long ostaliCasovi, Predmet preduslov, Set<Ishod> ishodi,
			Set<GodinaStudija> godineStudija, RealizacijaPredmeta realizacijaPredmeta) {
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

	public Predmet getPreduslov() {
		return preduslov;
	}

	public void setPreduslov(Predmet preduslov) {
		this.preduslov = preduslov;
	}

	public Set<Ishod> getIshodi() {
		return ishodi;
	}

	public void setIshodi(Set<Ishod> ishodi) {
		this.ishodi = ishodi;
	}

	public Set<GodinaStudija> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(Set<GodinaStudija> godineStudija) {
		this.godineStudija = godineStudija;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
}
