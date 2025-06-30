package com.univerzitet.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class TipNastave {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;

	@ManyToOne
	private NastavnikNaRealizaciji nastavnikNaRealizaciji;

	public TipNastave() {
		super();
	}

	public TipNastave(Long id, String naziv, NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
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

	public NastavnikNaRealizaciji getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
}
