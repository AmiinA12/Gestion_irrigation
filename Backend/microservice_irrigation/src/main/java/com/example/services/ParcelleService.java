package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ParcelleDTO;
import com.example.mapper.ParcelleMapper;
import com.example.models.Parcelle;
import com.example.repositories.ParcelleRepository;

@Service
public class ParcelleService {
	 @Autowired
	    private ParcelleRepository parcelleRepository;

	    public List<ParcelleDTO> getAll() {
	        return parcelleRepository.findAll().stream()
	                .map(ParcelleMapper::toDTO).toList();
	    }

	    public ParcelleDTO save(ParcelleDTO dto) {
	        Parcelle p = ParcelleMapper.toEntity(dto);
	        return ParcelleMapper.toDTO(parcelleRepository.save(p));
	    }
	    
	    public List<ParcelleDTO> getByCapteurId(Long capteurId) {
			return parcelleRepository.findByCapteurId(capteurId).stream()
					.map(ParcelleMapper::toDTO).toList();
		}
	 // READ: by ID
	    public ParcelleDTO getById(Long id) {
	        return parcelleRepository.findById(id)
	                .map(ParcelleMapper::toDTO)
	                .orElse(null);
	    }

	    // UPDATE
	    public ParcelleDTO update(Long id, ParcelleDTO dto) {
	        Parcelle existing = parcelleRepository.findById(id).orElse(null);
	        if (existing == null) return null;

	        existing.setNom(dto.getNom());
	        existing.setSuperficie(dto.getSuperficie());
	        existing.setSeuilHumiditeMin(dto.getSeuilHumiditeMin());
	        existing.setSeuilHumiditeMax(dto.getSeuilHumiditeMax());
	        existing.setCapteurId(dto.getCapteurId());

	        Parcelle updated = parcelleRepository.save(existing);
	        return ParcelleMapper.toDTO(updated);
	    }

	    // DELETE
	    public boolean delete(Long id) {
	        if (!parcelleRepository.existsById(id)) return false;
	        parcelleRepository.deleteById(id);
	        return true;
	    }
}
