package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Drzava {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@OneToMany(mappedBy = "drzava")
	private Set<Mesto> mesta;

	public Drzava() {
		super();
	}

	public Drzava(Long id, String naziv, Set<Mesto> mesta) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.mesta = mesta;
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

	public Set<Mesto> getMesta() {
		return mesta;
	}

	public void setMesta(Set<Mesto> mesta) {
		this.mesta = mesta;
	}	
}
