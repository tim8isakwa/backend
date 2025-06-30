package com.univerzitet.app.dto;

import java.time.LocalDate;

public class ZvanjeDTO {

	private Long id;
	
	private LocalDate datumIzbora;
	
	private LocalDate datumPrestanka;
	
	private String tipZvanja;
	
	private String naucnaOblast;
	
	private NastavnikDTO nastavnik;

	public ZvanjeDTO() {
		super();
	}

	public ZvanjeDTO(Long id, LocalDate datumIzbora, LocalDate datumPrestanka, String tipZvanja, String naucnaOblast,
			NastavnikDTO nastavnik) {
		super();
		this.id = id;
		this.datumIzbora = datumIzbora;
		this.datumPrestanka = datumPrestanka;
		this.tipZvanja = tipZvanja;
		this.naucnaOblast = naucnaOblast;
		this.nastavnik = nastavnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumIzbora() {
		return datumIzbora;
	}

	public void setDatumIzbora(LocalDate datumIzbora) {
		this.datumIzbora = datumIzbora;
	}

	public LocalDate getDatumPrestanka() {
		return datumPrestanka;
	}

	public void setDatumPrestanka(LocalDate datumPrestanka) {
		this.datumPrestanka = datumPrestanka;
	}

	public String getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(String tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public String getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(String naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}
}
