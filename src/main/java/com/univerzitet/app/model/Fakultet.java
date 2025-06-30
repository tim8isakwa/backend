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
public class Fakultet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;

	@Lob
	private String opis;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToOne
	private Nastavnik dekan;
	
	@OneToMany
	private Set<StudijskiProgram> programi;
	
	@ManyToOne
	private Univerzitet univerzitet;

	public Fakultet() {
		super();
	}

	public Fakultet(Long id, String naziv, String opis, Adresa adresa, Nastavnik dekan, Set<StudijskiProgram> programi,
			Univerzitet univerzitet) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.adresa = adresa;
		this.dekan = dekan;
		this.programi = programi;
		this.univerzitet = univerzitet;
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

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nastavnik getDekan() {
		return dekan;
	}

	public void setDekan(Nastavnik dekan) {
		this.dekan = dekan;
	}

	public Set<StudijskiProgram> getProgrami() {
		return programi;
	}

	public void setProgrami(Set<StudijskiProgram> programi) {
		this.programi = programi;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}
}
