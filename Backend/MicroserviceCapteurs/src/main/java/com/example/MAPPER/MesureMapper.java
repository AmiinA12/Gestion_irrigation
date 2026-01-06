package com.example.MAPPER;

import com.example.dto.MesureDTO;
import com.example.models.Mesure;

public class MesureMapper {
	  public static MesureDTO toDTO(Mesure mesure) {
	        MesureDTO dto = new MesureDTO();
	        dto.setId(mesure.getId());
	        dto.setValeur(mesure.getValeur());
	        dto.setUnite(mesure.getUnite());
	        dto.setDateMesure(mesure.getDateMesure());
	        dto.setCapteurId(mesure.getCapteurId());
	        return dto;
	  }
	        public static Mesure toEntity(MesureDTO dto) {
	            Mesure mesure = new Mesure();
	            mesure.setId(dto.getId());
	            mesure.setValeur(dto.getValeur());
	            mesure.setUnite(dto.getUnite());
	            mesure.setDateMesure(dto.getDateMesure());
	            mesure.setCapteurId(dto.getCapteurId());
	            return mesure;

}}
