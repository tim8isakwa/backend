package com.univerzitet.app.dto;

import java.util.Set;

public class NastavnikDTO extends RegistrovaniKorisnikDTO {

	private String jmbg;
	
	private String ime;
	
	private String biografija;
	
	private AdresaDTO adresa;
	
	private ZvanjeDTO zvanje;

	public NastavnikDTO() {
		super();
	}

	public NastavnikDTO(Long id, String korisnickoIme, String email, boolean aktivan,
	                    Set<DodeljenoPravoPristupaDTO> dodeljenaPrava,
	                    String jmbg, String ime, String biografija,
	                    AdresaDTO adresa, ZvanjeDTO zvanje) {
		super(id, korisnickoIme, email, aktivan, dodeljenaPrava);
		this.jmbg = jmbg;
		this.ime = ime;
		this.biografija = biografija;
		this.adresa = adresa;
		this.zvanje = zvanje;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public ZvanjeDTO getZvanje() {
		return zvanje;
	}

	public void setZvanje(ZvanjeDTO zvanje) {
		this.zvanje = zvanje;
	}
}
