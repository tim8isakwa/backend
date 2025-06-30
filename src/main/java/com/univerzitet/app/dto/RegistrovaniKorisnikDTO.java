package com.univerzitet.app.dto;

import java.util.Set;

public class RegistrovaniKorisnikDTO {

	private Long id;
	
	private String korisnickoIme;
	
	private String lozinka;
	
	private String email;
	
	private boolean aktivan;
	
	private Set<DodeljenoPravoPristupaDTO> dodeljenaPrava;

	public RegistrovaniKorisnikDTO() {
		super();
	}

	public RegistrovaniKorisnikDTO(Long id, String korisnickoIme, String email, boolean aktivan,
			Set<DodeljenoPravoPristupaDTO> dodeljenaPrava) {
		super();
		this.id = id;
		this.korisnickoIme = korisnickoIme;
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

	public Set<DodeljenoPravoPristupaDTO> getDodeljenaPrava() {
		return dodeljenaPrava;
	}

	public void setDodeljenaPrava(Set<DodeljenoPravoPristupaDTO> dodeljenaPrava) {
		this.dodeljenaPrava = dodeljenaPrava;
	}
}
