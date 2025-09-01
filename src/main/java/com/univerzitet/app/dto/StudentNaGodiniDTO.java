package com.univerzitet.app.dto;

import java.time.LocalDate;

public class StudentNaGodiniDTO {

	private Long id;
	
	private LocalDate datumUpisa;
	
	private String brojIndeksa;

	private StudentDTO student;

	private LocalDate godinaStudija;

	public StudentNaGodiniDTO() {
		super();
	}

	public StudentNaGodiniDTO(Long id, LocalDate datumUpisa, String brojIndeksa,
	                          StudentDTO student, LocalDate godinaStudija) {
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

	public LocalDate getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(LocalDate godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
}
