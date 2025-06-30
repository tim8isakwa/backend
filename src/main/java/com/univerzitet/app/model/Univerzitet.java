package com.univerzitet.app.model;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Univerzitet {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate datumOsnivanja;
	
	@OneToOne
	private Adresa adresa;
	
	@ManyToOne
	private Nastavnik rektor;
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Fakultet> fakulteti;
	
	public Univerzitet() {
		super();
	}

	public Univerzitet(Long id, String naziv, LocalDate datumOsnivanja, Adresa adresa, Nastavnik rektor,
			Set<Fakultet> fakulteti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.adresa = adresa;
		this.rektor = rektor;
		this.fakulteti = fakulteti;
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

	public LocalDate getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDate datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Nastavnik getRektor() {
		return rektor;
	}

	public void setRektor(Nastavnik rektor) {
		this.rektor = rektor;
	}

	public Set<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(Set<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}
}
