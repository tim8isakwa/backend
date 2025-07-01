package com.univerzitet.app.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Nastavnik extends RegistrovaniKorisnik {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String jmbg;
	
	@Lob
	private String ime;
	@Lob
	private String biografija;
	
	@OneToOne
	private Adresa adresa;
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Zvanje> zvanja;
	
	@ManyToOne
	private NastavnikNaRealizaciji nastavnikNaRealizaciji;

	public Nastavnik() {
		super();
	}

	public Nastavnik(Long id, String korisnickoIme, String lozinka, String email, boolean aktivan,
			Set<DodeljenoPravoPristupa> dodeljenaPrava) {
		super(id, korisnickoIme, lozinka, email, aktivan, dodeljenaPrava);
	}

	public Nastavnik(Long id, String jmbg, String ime, String biografija, Adresa adresa, Set<Zvanje> zvanja) {
		super();
		this.id = id;
		this.jmbg = jmbg;
		this.ime = ime;
		this.biografija = biografija;
		this.adresa = adresa;
		this.zvanja = zvanja;
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

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public Set<Zvanje> getZvanja() {
		return zvanja;
	}

	public void setZvanja(Set<Zvanje> zvanja) {
		this.zvanja = zvanja;
	}

	public NastavnikNaRealizaciji getNastavnikNaRealizaciji() {
		return nastavnikNaRealizaciji;
	}

	public void setNastavnikNaRealizaciji(NastavnikNaRealizaciji nastavnikNaRealizaciji) {
		this.nastavnikNaRealizaciji = nastavnikNaRealizaciji;
	}
}
