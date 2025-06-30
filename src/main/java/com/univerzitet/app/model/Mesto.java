package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Mesto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@OneToMany(mappedBy = "mesto")
	private Set<Adresa> adrese;
	
	@ManyToOne
	private Drzava drzava;

	public Mesto() {
		super();
	}

	public Mesto(Long id, String naziv, Set<Adresa> adrese, Drzava drzava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.adrese = adrese;
		this.drzava = drzava;
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

	public Set<Adresa> getAdrese() {
		return adrese;
	}

	public void setAdrese(Set<Adresa> adrese) {
		this.adrese = adrese;
	}

	public Drzava getDrzava() {
		return drzava;
	}

	public void setDrzava(Drzava drzava) {
		this.drzava = drzava;
	}
}
