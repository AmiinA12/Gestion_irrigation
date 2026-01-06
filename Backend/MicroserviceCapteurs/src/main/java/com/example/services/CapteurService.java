package com.example.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.MAPPER.CapteurMapper;
import com.example.dto.CapteurDTO;
import com.example.models.Capteur;
import com.example.models.Mesure;
import com.example.repositories.CapteurRepository;
import com.example.repositories.MesureRepository;
@Service
public class CapteurService {
	 @Autowired
	    private CapteurRepository capteurRepository;

	    public List<CapteurDTO> getAllCapteurs() {
	        return capteurRepository.findAll()
	                .stream()
	                .map(CapteurMapper::toDTO)
	                .toList();
	    }

	    public CapteurDTO saveCapteur(CapteurDTO dto) {
	        Capteur capteur = CapteurMapper.toEntity(dto);
	        Capteur saved = capteurRepository.save(capteur);
	        return CapteurMapper.toDTO(saved);
	    }

	    public CapteurDTO getCapteurById(Long id) {
	        return capteurRepository.findById(id)
	                .map(CapteurMapper::toDTO)
	                .orElse(null);
	    }
	    
	    public CapteurDTO updateCapteur(Long id, CapteurDTO dto) {

	        Capteur capteur = capteurRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Capteur introuvable"));

	        // mise à jour des champs
	        capteur.setType(dto.getType());
	        capteur.setLocalisation(dto.getLocalisation());
	        capteur.setEtat(dto.getEtat());

	        Capteur updated = capteurRepository.save(capteur);
	        return CapteurMapper.toDTO(updated);
	    }

	    // ================= DELETE =================
	    public void deleteCapteur(Long id) {
	        if (!capteurRepository.existsById(id)) {
	            throw new RuntimeException("Capteur introuvable");
	        }
	        capteurRepository.deleteById(id);
	    }
}
