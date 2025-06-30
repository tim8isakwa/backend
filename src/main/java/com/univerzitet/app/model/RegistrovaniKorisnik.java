package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RegistrovaniKorisnik {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String korisnickoIme;
	
	private String lozinka;
	
	@Column(unique = true)
	private String email;
	
	private boolean aktivan;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "registrovaniKorisnik", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<DodeljenoPravoPristupa> dodeljenaPrava;

	public RegistrovaniKorisnik() {
		super();
	}

	public RegistrovaniKorisnik(Long id, String korisnickoIme, String lozinka, String email, boolean aktivan,
			Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.aktivan = aktivan;
		this.dodeljenaPrava = dodeljenaPrava;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public Set<DodeljenoPravoPristupa> getDodeljenaPrava() {
		return dodeljenaPrava;
	}

	public void setDodeljenaPrava(Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		this.dodeljenaPrava = dodeljenaPrava;
	}
}
