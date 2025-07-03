package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class PohadjanjePredmeta {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private RealizacijaPredmeta realizacijaPredmeta;
	
	@ManyToOne
	private Student student;
	
	@OneToMany(mappedBy = "pohadjanjePredmeta")
	private Set<Polaganje> polaganja;

	public PohadjanjePredmeta() {
		super();
	}

	public PohadjanjePredmeta(Long id, RealizacijaPredmeta realizacijaPredmeta, Student student, Set<Polaganje> polaganje) {
		super();
		this.id = id;
		this.realizacijaPredmeta = realizacijaPredmeta;
		this.student = student;
		this.polaganja = polaganje;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Set<Polaganje> getPolaganja() {
	    return polaganja;
	}

	public void setPolaganja(Set<Polaganje> polaganja) {
	    this.polaganja = polaganja;
	}
}
