package com.univerzitet.app.dto;

import java.time.LocalDateTime;

public class ObavestenjeDTO {
    private Long id;
    private String sadrzaj;
    private LocalDateTime datumPostavljanja;
    private Long realizacijaPredmetaId;
	public ObavestenjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ObavestenjeDTO(Long id, String sadrzaj, LocalDateTime datumPostavljanja, Long realizacijaPredmetaId) {
		super();
		this.id = id;
		this.sadrzaj = sadrzaj;
		this.datumPostavljanja = datumPostavljanja;
		this.realizacijaPredmetaId = realizacijaPredmetaId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSadrzaj() {
		return sadrzaj;
	}
	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}
	public LocalDateTime getDatumPostavljanja() {
		return datumPostavljanja;
	}
	public void setDatumPostavljanja(LocalDateTime datumPostavljanja) {
		this.datumPostavljanja = datumPostavljanja;
	}
	public Long getRealizacijaPredmetaId() {
		return realizacijaPredmetaId;
	}
	public void setRealizacijaPredmetaId(Long realizacijaPredmetaId) {
		this.realizacijaPredmetaId = realizacijaPredmetaId;
	}

    
}
