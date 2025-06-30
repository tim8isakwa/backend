package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class RealizacijaPredmeta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "realizacijaPredmeta")
	private Set<Predmet> predmeti;

	@OneToMany(mappedBy = "realizacijaPredmeta")
	private Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji;
	
	public RealizacijaPredmeta() {
		super();
	}

	public RealizacijaPredmeta(Long id, Set<Predmet> predmeti, Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
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

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public Set<NastavnikNaRealizaciji> getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(Set<NastavnikNaRealizaciji> nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
}