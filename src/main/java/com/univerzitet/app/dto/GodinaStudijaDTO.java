package com.univerzitet.app.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class GodinaStudijaDTO {

	private Long id;
	
	private LocalDate godina;

	private List<PredmetDTO> predmeti;
	
	private StudijskiProgramDTO studijskiProgram;
	
	private Set<StudentNaGodiniDTO> studentiNaGodini;

	public GodinaStudijaDTO() {
		super();
	}

	public GodinaStudijaDTO(Long id, LocalDate godina, List<PredmetDTO> predmeti, StudijskiProgramDTO studijskiProgram,
			Set<StudentNaGodiniDTO> studentiNaGodini) {
		super();
		this.id = id;
		this.godina = godina;
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
	
	public List<PredmetDTO> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<PredmetDTO> predmeti) {
		this.predmeti = predmeti;
	}

	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

	public Set<StudentNaGodiniDTO> getStudentiNaGodini() {
		return studentiNaGodini;
	}

	public void setStudentiNaGodini(Set<StudentNaGodiniDTO> studentiNaGodini) {
		this.studentiNaGodini = studentiNaGodini;
	}
}
