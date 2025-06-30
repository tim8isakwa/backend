package com.univerzitet.app.dto;

import java.util.Set;

public class StudijskiProgramDTO {

	private Long id;
	
	private String naziv;

	private String opis;
	
	private NastavnikDTO rukovodilac;
	
	private FakultetDTO fakultet;
	
	private Set<GodinaStudijaDTO> godineStudija;

	public StudijskiProgramDTO() {
		super();
	}

	public StudijskiProgramDTO(Long id, String naziv, String opis, NastavnikDTO rukovodilac,
	                           FakultetDTO fakultet, Set<GodinaStudijaDTO> godineStudija) {
		this.id = id;
		this.naziv = naziv;
		this.opis = opis;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
		this.godineStudija = godineStudija;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public NastavnikDTO getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(NastavnikDTO rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public FakultetDTO getFakultet() {
		return fakultet;
	}

	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public Set<GodinaStudijaDTO> getGodineStudija() {
		return godineStudija;
	}

	public void setGodineStudija(Set<GodinaStudijaDTO> godineStudija) {
		this.godineStudija = godineStudija;
	}
}
