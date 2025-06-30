package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class StudijskiProgram {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@Lob
	private String opis;
	
	@OneToOne
	private Nastavnik rukovodilac;
	
	@ManyToOne
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "studijskiProgram")
	private Set<GodinaStudija> godinaStudija;

	public StudijskiProgram() {
		super();
	}

	public StudijskiProgram(Long id, String naziv, String opis, Nastavnik rukovodilac, Fakultet fakultet,
			Set<GodinaStudija> godinaStudija) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
		this.godinaStudija = godinaStudija;
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
	
	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Nastavnik getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(Nastavnik rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Set<GodinaStudija> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Set<GodinaStudija> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
}
