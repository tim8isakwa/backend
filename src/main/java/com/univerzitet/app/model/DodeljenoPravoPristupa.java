package com.univerzitet.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class DodeljenoPravoPristupa {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private RegistrovaniKorisnik registrovaniKorisnik;
	
	@ManyToOne
	private PravoPristupa pravoPristupa;

	public DodeljenoPravoPristupa() {
		super();
	}

	public DodeljenoPravoPristupa(Long id, RegistrovaniKorisnik registrovaniKorisnik, PravoPristupa pravoPristupa) {
		super();
		this.id = id;
		this.registrovaniKorisnik = registrovaniKorisnik;
		this.pravoPristupa = pravoPristupa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public PravoPristupa getPravoPristupa() {
		return pravoPristupa;
	}

	public void setPravoPristupa(PravoPristupa pravoPristupa) {
		this.pravoPristupa = pravoPristupa;
	}
}
