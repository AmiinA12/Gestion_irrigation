package com.example.mapper;


import com.example.dto.ParcelleDTO;
import com.example.models.Parcelle;

public class ParcelleMapper {
	public static ParcelleDTO toDTO(Parcelle p) {
		ParcelleDTO dto = new ParcelleDTO();
		dto.setId(p.getId());
		dto.setNom(p.getNom());
		dto.setSuperficie(p.getSuperficie());
		dto.setSeuilHumiditeMin(p.getSeuilHumiditeMin());
		dto.setSeuilHumiditeMax(p.getSeuilHumiditeMax());
		dto.setCapteurId(p.getCapteurId());
		return dto;
	}

	public static Parcelle toEntity(ParcelleDTO dto) {
		Parcelle p = new Parcelle();
		p.setId(dto.getId());
		p.setNom(dto.getNom());
		p.setSuperficie(dto.getSuperficie());
		p.setSeuilHumiditeMin(dto.getSeuilHumiditeMin());
		p.setSeuilHumiditeMax(dto.getSeuilHumiditeMax());
		p.setCapteurId(dto.getCapteurId());
		return p;
	}


}
