package com.univerzitet.app.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Zvanje {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate datumIzbora;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate datumPrestanka;
	
	@ManyToOne
	private TipZvanja tipZvanja;
	
	@ManyToOne
	private NaucnaOblast naucnaOblast;
	
	@ManyToOne
	private Nastavnik nastavnik;
	
	public Zvanje() {
		super();
	}

	public Zvanje(Long id, LocalDate datumIzbora, LocalDate datumPrestanka, TipZvanja tipZvanja,
			NaucnaOblast naucnaOblast, Nastavnik nastavnik) {
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

	public TipZvanja getTipZvanja() {
		return tipZvanja;
	}

	public void setTipZvanja(TipZvanja tipZvanja) {
		this.tipZvanja = tipZvanja;
	}

	public NaucnaOblast getNaucnaOblast() {
		return naucnaOblast;
	}

	public void setNaucnaOblast(NaucnaOblast naucnaOblast) {
		this.naucnaOblast = naucnaOblast;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}
}
