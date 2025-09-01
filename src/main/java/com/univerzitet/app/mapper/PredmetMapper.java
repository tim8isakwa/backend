package com.univerzitet.app.mapper;

import org.springframework.stereotype.Component;

import com.univerzitet.app.dto.PredmetDTO;
import com.univerzitet.app.model.Predmet;

@Component
public class PredmetMapper {

	public PredmetDTO mapToDTO(Predmet predmet) {
		PredmetDTO dto = new PredmetDTO();
		
		dto.setId(predmet.getId());
		
		return dto;
	}
}
