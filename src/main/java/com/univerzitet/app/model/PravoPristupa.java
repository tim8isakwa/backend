package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PravoPristupa {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String naziv;
	
	@OneToMany(mappedBy = "pravoPristupa")
	private Set<DodeljenoPravoPristupa> dodeljenaPrava;

	public PravoPristupa() {
		super();
	}

	public PravoPristupa(Long id, String naziv, Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.dodeljenaPrava = dodeljenaPrava;
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

	public Set<DodeljenoPravoPristupa> getDodeljenaPrava() {
		return dodeljenaPrava;
	}

	public void setDodeljenaPrava(Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		this.dodeljenaPrava = dodeljenaPrava;
	}
}
