package com.example.mapper;

import com.example.dto.ActionIrrigationDTO;
import com.example.models.ActionIrrigation;

public class ActionIrrigationMapper {
	public static ActionIrrigationDTO toDTO(ActionIrrigation a) {
        ActionIrrigationDTO dto = new ActionIrrigationDTO();
        dto.setId(a.getId());
        dto.setParcelleId(a.getParcelleId());
        dto.setDateDebut(a.getDateDebut());
        dto.setDuree(a.getDuree());
        dto.setVolumeEau(a.getVolumeEau());
        dto.setStatut(a.getStatut());
        return dto;
    }

    public static ActionIrrigation toEntity(ActionIrrigationDTO dto) {
        ActionIrrigation a = new ActionIrrigation();
        a.setId(dto.getId());
        a.setParcelleId(dto.getParcelleId());
        a.setDateDebut(dto.getDateDebut());
        a.setDuree(dto.getDuree());
        a.setVolumeEau(dto.getVolumeEau());
        a.setStatut(dto.getStatut());
        return a;
    }


}
