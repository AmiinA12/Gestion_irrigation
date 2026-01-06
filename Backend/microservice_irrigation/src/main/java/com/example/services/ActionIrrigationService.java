package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ActionIrrigationDTO;
import com.example.mapper.ActionIrrigationMapper;
import com.example.models.ActionIrrigation;
import com.example.repositories.ActionIrrigationRepository;

@Service
public class ActionIrrigationService {
	 @Autowired
	    private ActionIrrigationRepository actionRepo;

	    public ActionIrrigationDTO save(ActionIrrigationDTO dto) {
	        ActionIrrigation a = ActionIrrigationMapper.toEntity(dto);
	        return ActionIrrigationMapper.toDTO(actionRepo.save(a));
	    }

	    public List<ActionIrrigationDTO> getAll() {
	        return actionRepo.findAll().stream()
	                .map(ActionIrrigationMapper::toDTO).toList();
	    }
	    
	 // READ: by ID
	    public ActionIrrigationDTO getById(Long id) {
	        return actionRepo.findById(id)
	                .map(ActionIrrigationMapper::toDTO)
	                .orElse(null);
	    }

	    // UPDATE
	    public ActionIrrigationDTO update(Long id, ActionIrrigationDTO dto) {
	        ActionIrrigation existing = actionRepo.findById(id).orElse(null);
	        if (existing == null) return null;

	        existing.setParcelleId(dto.getParcelleId());
	        existing.setDateDebut(dto.getDateDebut());
	        existing.setDuree(dto.getDuree());
	        existing.setVolumeEau(dto.getVolumeEau());
	        existing.setStatut(dto.getStatut());

	        return ActionIrrigationMapper.toDTO(actionRepo.save(existing));
	    }

	    // DELETE
	    public boolean delete(Long id) {
	        if (!actionRepo.existsById(id)) return false;
	        actionRepo.deleteById(id);
	        return true;
	    }

}
