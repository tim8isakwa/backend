package com.univerzitet.app.dto;

import java.util.Set;

public class StudentDTO extends RegistrovaniKorisnikDTO {

	private String jmbg;
	
	private String ime;
	
	private AdresaDTO adresa;
	
	private Set<StudentNaGodiniDTO> studentNaGodinima;
	
	private Set<PohadjanjePredmetaDTO> pohadjanjePredmeta;

	public StudentDTO() {
		super();
	}

	public StudentDTO(Long id, String korisnickoIme, String email, boolean aktivan,
	                  Set<DodeljenoPravoPristupaDTO> dodeljenaPrava,
	                  String jmbg, String ime, AdresaDTO adresa,
	                  Set<StudentNaGodiniDTO> studentNaGodinima,
	                  Set<PohadjanjePredmetaDTO> pohadjanjePredmeta) {
		super(id, korisnickoIme, email, aktivan, dodeljenaPrava);
		this.jmbg = jmbg;
		this.ime = ime;
		this.adresa = adresa;
		this.studentNaGodinima = studentNaGodinima;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
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

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public Set<StudentNaGodiniDTO> getStudentNaGodinima() {
		return studentNaGodinima;
	}

	public void setStudentNaGodinima(Set<StudentNaGodiniDTO> studentNaGodinima) {
		this.studentNaGodinima = studentNaGodinima;
	}

	public Set<PohadjanjePredmetaDTO> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Set<PohadjanjePredmetaDTO> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
}
