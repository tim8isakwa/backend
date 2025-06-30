package com.univerzitet.app.dto;

import java.time.LocalDate;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

public class UniverzitetDTO {

	private Long id;
	
	private String naziv;

	private LocalDate datumOsnivanja;

	private String opis;
	
	private AdresaDTO adresa;
	
	private NastavnikDTO rektor;
	
	private Set<FakultetDTO> fakulteti;

	public UniverzitetDTO() {
		super();
	}

	public UniverzitetDTO(Long id, String naziv, LocalDate datumOsnivanja, String opis, AdresaDTO adresa,
	                      NastavnikDTO rektor, Set<FakultetDTO> fakulteti) {
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.opis = opis;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public NastavnikDTO getRektor() {
		return rektor;
	}

	public void setRektor(NastavnikDTO rektor) {
		this.rektor = rektor;
	}

	public Set<FakultetDTO> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(Set<FakultetDTO> fakulteti) {
		this.fakulteti = fakulteti;
	}
}
