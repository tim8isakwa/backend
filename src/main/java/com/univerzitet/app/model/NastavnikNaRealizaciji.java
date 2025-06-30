package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class NastavnikNaRealizaciji {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long brojCasova;
	
	@OneToMany(mappedBy = "nastavnikNaRealizaciji")
	private Set<Nastavnik> nastavnici;
	
	@OneToMany(mappedBy = "nastavnikNaRealizaciji")
	private Set<TipNastave> tipoviNastave;
	
	@ManyToOne
	private RealizacijaPredmeta realizacijaPredmeta;

	public NastavnikNaRealizaciji() {
		super();
	}

	public NastavnikNaRealizaciji(Long id, Long brojCasova, Set<Nastavnik> nastavnici, Set<TipNastave> tipoviNastave,
			RealizacijaPredmeta realizacijaPredmeta) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnici = nastavnici;
		this.tipoviNastave = tipoviNastave;
		this.realizacijaPredmeta = realizacijaPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(Long brojCasova) {
		this.brojCasova = brojCasova;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}

	public Set<TipNastave> getTipoviNastave() {
		return tipoviNastave;
	}

	public void setTipoviNastave(Set<TipNastave> tipoviNastave) {
		this.tipoviNastave = tipoviNastave;
	}

	public RealizacijaPredmeta getRealizacijaPredmeta() {
		return realizacijaPredmeta;
	}

	public void setRealizacijaPredmeta(RealizacijaPredmeta realizacijaPredmeta) {
		this.realizacijaPredmeta = realizacijaPredmeta;
	}
}
