package com.univerzitet.app.dto;

import java.util.Set;

public class FakultetDTO {

	private Long id;
	
	private String naziv;

	private AdresaDTO adresa;
	
	private NastavnikDTO dekan;
	
	private Set<StudijskiProgramDTO> programi;
	
	private UniverzitetDTO univerzitet;

	public FakultetDTO() {
		super();
	}

	public FakultetDTO(Long id, String naziv, AdresaDTO adresa, NastavnikDTO dekan,
	                   Set<StudijskiProgramDTO> programi, UniverzitetDTO univerzitet) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.dekan = dekan;
		this.programi = programi;
		this.univerzitet = univerzitet;
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

	public AdresaDTO getAdresa() {
		return adresa;
	}

	public void setAdresa(AdresaDTO adresa) {
		this.adresa = adresa;
	}

	public NastavnikDTO getDekan() {
		return dekan;
	}

	public void setDekan(NastavnikDTO dekan) {
		this.dekan = dekan;
	}

	public Set<StudijskiProgramDTO> getProgrami() {
		return programi;
	}

	public void setProgrami(Set<StudijskiProgramDTO> programi) {
		this.programi = programi;
	}

	public UniverzitetDTO getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}
}
