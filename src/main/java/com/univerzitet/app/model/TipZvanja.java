package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class TipZvanja {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String naziv;
	
	@OneToMany
	private Set<Zvanje> zvanja;

	public TipZvanja() {
		super();
	}

	public TipZvanja(Long id, String naziv, Set<Zvanje> zvanja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zvanja = zvanja;
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

	public Set<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(Set<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}
}
