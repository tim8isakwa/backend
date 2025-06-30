package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Student extends RegistrovaniKorisnik {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String jmbg;
	
	@Lob
	private String ime;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "student")
	private Set<StudentNaGodini> studentNaGodinima;
	
	@OneToMany(mappedBy = "student")
	private Set<PohadjanjePredmeta> pohadjanjePredmeta;

	public Student() {
		super();
	}

	public Student(Long id, String korisnickoIme, String lozinka, String email, boolean aktivan,
			Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		super(id, korisnickoIme, lozinka, email, aktivan, dodeljenaPrava);
	}

	public Student(Long id, String jmbg, String ime, Adresa adresa, Set<StudentNaGodini> studentNaGodinima,
			Set<PohadjanjePredmeta> pohadjanjePredmeta) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.adresa = adresa;
		this.studentNaGodinima = studentNaGodinima;
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Set<StudentNaGodini> getStudentNaGodinima() {
		return studentNaGodinima;
	}

	public void setStudentNaGodinima(Set<StudentNaGodini> studentNaGodinima) {
		this.studentNaGodinima = studentNaGodinima;
	}

	public Set<PohadjanjePredmeta> getPohadjanjePredmeta() {
		return pohadjanjePredmeta;
	}

	public void setPohadjanjePredmeta(Set<PohadjanjePredmeta> pohadjanjePredmeta) {
		this.pohadjanjePredmeta = pohadjanjePredmeta;
	}
}
