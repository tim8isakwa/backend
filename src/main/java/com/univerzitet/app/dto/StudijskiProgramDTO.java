package com.univerzitet.app.dto;

import java.util.Set;

public class StudijskiProgramDTO {

	private Long id;
	
	private String naziv;

	private NastavnikDTO rukovodilac;
	
	private FakultetDTO fakultet;
	
	private Set<GodinaStudijaDTO> godineStudija;

	public StudijskiProgramDTO() {
		super();
	}

	public StudijskiProgramDTO(Long id, String naziv, NastavnikDTO rukovodilac,
	                           FakultetDTO fakultet, Set<GodinaStudijaDTO> godineStudija) {
		this.id = id;
		this.naziv = naziv;
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
