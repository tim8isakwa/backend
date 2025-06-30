package com.univerzitet.app.dto;

public class DodeljenoPravoPristupaDTO {

	private Long id;
	
	private String pravoPristupa;

	public DodeljenoPravoPristupaDTO() {
		super();
	}

	public DodeljenoPravoPristupaDTO(Long id, String pravoPristupa) {
		super();
		this.id = id;
		this.pravoPristupa = pravoPristupa;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPravoPristupa() {
		return pravoPristupa;
	}

	public void setPravoPristupa(String pravoPristupa) {
		this.pravoPristupa = pravoPristupa;
	}
}
