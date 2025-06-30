package com.univerzitet.app.dto;

import java.util.Set;

public class PravoPristupaDTO {

	private Long id;
	
	private String naziv;
	
	private Set<DodeljenoPravoPristupaDTO> dodeljenoPravo;

	public PravoPristupaDTO() {
		super();
	}

	public PravoPristupaDTO(Long id, String naziv, Set<DodeljenoPravoPristupaDTO> dodeljenoPravo) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.dodeljenoPravo = dodeljenoPravo;
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

	public Set<DodeljenoPravoPristupaDTO> getDodeljenoPravo() {
		return dodeljenoPravo;
	}

	public void setDodeljenoPravo(Set<DodeljenoPravoPristupaDTO> dodeljenoPravo) {
		this.dodeljenoPravo = dodeljenoPravo;
	}
}
