package com.example.MAPPER;

import com.example.dto.CapteurDTO;
import com.example.models.Capteur;

public class CapteurMapper {
	 public static CapteurDTO toDTO(Capteur capteur) {
	        CapteurDTO dto = new CapteurDTO();
	        dto.setId(capteur.getId());
	        dto.setType(capteur.getType());
	        dto.setLocalisation(capteur.getLocalisation());
	        dto.setEtat(capteur.getEtat());
	        dto.setDateInstallation(capteur.getDateInstallation());
	        return dto;
	    }

	    public static Capteur toEntity(CapteurDTO dto) {
	        Capteur capteur = new Capteur();
	        capteur.setId(dto.getId());
	        capteur.setType(dto.getType());
	        capteur.setLocalisation(dto.getLocalisation());
	        capteur.setEtat(dto.getEtat());
	        capteur.setDateInstallation(dto.getDateInstallation());
	        return capteur;
	    }

}
