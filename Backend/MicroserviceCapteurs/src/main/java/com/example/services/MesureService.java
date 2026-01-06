package com.example.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.MAPPER.MesureMapper;
import com.example.dto.MesureDTO;
import com.example.models.Mesure;
import com.example.repositories.MesureRepository;
@Service
public class MesureService {
	 @Autowired
	    private MesureRepository mesureRepository;

	    @Autowired
	    private KafkaTemplate<String, MesureDTO> kafkaTemplate;

	    private static final String TOPIC = "capteurs.mesures";


	    public MesureDTO save(MesureDTO dto) {
	        Mesure mesure = MesureMapper.toEntity(dto);
	        mesure.setDateMesure(LocalDateTime.now());

	        Mesure saved = mesureRepository.save(mesure);
	        MesureDTO result = MesureMapper.toDTO(saved);

	        kafkaTemplate.send(TOPIC, result);

	        return result;
	    }

	    public MesureDTO getLatest(Long capteurId) {
	        List<Mesure> mesures = mesureRepository.findLatestByCapteurId(capteurId);
	        return mesures.isEmpty() ? null : MesureMapper.toDTO(mesures.get(0));
	    }
	    
	    // READ: all by capteur
	    public List<MesureDTO> getAllByCapteur(Long capteurId) {
	        return mesureRepository.findByCapteurId(capteurId)
	                .stream()
	                .map(MesureMapper::toDTO)
	                .toList();
	    }

	    // UPDATE
	    public MesureDTO update(Long id, MesureDTO dto) {
	        Mesure existing = mesureRepository.findById(id).orElse(null);
	        if (existing == null) return null;

	        existing.setValeur(dto.getValeur());
	        existing.setUnite(dto.getUnite());
	        existing.setDateMesure(LocalDateTime.now());

	        Mesure updated = mesureRepository.save(existing);
	        MesureDTO result = MesureMapper.toDTO(updated);

	        kafkaTemplate.send(TOPIC, result);

	        return result;
	    }

	    // DELETE
	    public boolean delete(Long id) {
	        if (!mesureRepository.existsById(id)) return false;
	        mesureRepository.deleteById(id);
	        return true;
	    }
}
