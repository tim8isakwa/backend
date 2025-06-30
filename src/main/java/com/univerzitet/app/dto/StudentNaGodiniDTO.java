package com.univerzitet.app.dto;

import java.time.LocalDate;

public class StudentNaGodiniDTO {

	private Long id;
	
	private LocalDate datumUpisa;
	
	private String brojIndeksa;

	private StudentDTO student;

	private GodinaStudijaDTO godinaStudija;

	public StudentNaGodiniDTO() {
		super();
	}

	public StudentNaGodiniDTO(Long id, LocalDate datumUpisa, String brojIndeksa,
	                          StudentDTO student, GodinaStudijaDTO godinaStudija) {
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.brojIndeksa = brojIndeksa;
		this.student = student;
		this.godinaStudija = godinaStudija;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(LocalDate datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
}
