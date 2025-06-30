package com.univerzitet.app.dto;

public class AdresaDTO {

	private Long id;
	
	private String broj;
	
	private String ulica;
	
	private String mesto;
	
	private String drzava;

	public AdresaDTO() {
		super();
	}

	public AdresaDTO(Long id, String broj, String ulica, String mesto, String drzava) {
		super();
		this.id = id;
		this.broj = broj;
		this.ulica = ulica;
		this.mesto = mesto;
		this.drzava = drzava;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBroj() {
		return broj;
	}

	public void setBroj(String broj) {
		this.broj = broj;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}	
}
