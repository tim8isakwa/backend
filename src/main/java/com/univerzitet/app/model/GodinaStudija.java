package com.univerzitet.app.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class GodinaStudija {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate godina;
	
	@ManyToMany
	@JoinTable(
			name = "godina_predmet",
			joinColumns = @JoinColumn(name = "godina_id"),
			inverseJoinColumns = @JoinColumn(name = "predmet_id")
	)
	private List<Predmet> predmeti;
	
	@ManyToOne
	private StudijskiProgram studijskiProgram;
	
	@OneToMany(mappedBy = "godinaStudija")
	private Set<StudentNaGodini> studentiNaGodini;

	public GodinaStudija() {
		super();
	}

	public GodinaStudija(Long id, List<Predmet> predmeti, StudijskiProgram studijskiProgram,
			Set<StudentNaGodini> studentiNaGodini) {
		super();
		this.id = id;
		this.predmeti = predmeti;
		this.studijskiProgram = studijskiProgram;
		this.studentiNaGodini = studentiNaGodini;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getGodina() {
		return godina;
	}

	public void setGodina(LocalDate godina) {
		this.godina = godina;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Set<StudentNaGodini> getStudentiNaGodini() {
		return studentiNaGodini;
	}

	public void setStudentiNaGodini(Set<StudentNaGodini> studentiNaGodini) {
		this.studentiNaGodini = studentiNaGodini;
	}
}
