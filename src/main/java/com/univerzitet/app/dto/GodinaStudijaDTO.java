package com.univerzitet.app.dto;

import java.util.List;
import java.util.Set;

public class GodinaStudijaDTO {

	private Long id;

	private List<PredmetDTO> predmeti;
	
	private StudijskiProgramDTO studijskiProgram;
	
	private Set<StudentNaGodiniDTO> studentiNaGodini;

	public GodinaStudijaDTO() {
		super();
	}

	public GodinaStudijaDTO(Long id, List<PredmetDTO> predmeti,
	                        StudijskiProgramDTO studijskiProgram,
	                        Set<StudentNaGodiniDTO> studentiNaGodini) {
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
