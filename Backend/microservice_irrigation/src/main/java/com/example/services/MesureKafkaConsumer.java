package com.example.services;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.dto.ActionIrrigationDTO;
import com.example.dto.MesureDTO;
import com.example.dto.ParcelleDTO;



@Service
public class MesureKafkaConsumer {

    @Autowired
    private ActionIrrigationService actionService;

    @Autowired
    private ParcelleService parcelleService;

    @KafkaListener(topics = "capteurs.mesures", groupId = "irrigation-group")
    public void consume(MesureDTO mesure) {
        try {
            if (mesure == null || mesure.getCapteurId() == null) {
                System.err.println("Mesure reçue invalide, ignorée : " + mesure);
                return;
            }

            List<ParcelleDTO> parcelles = parcelleService.getByCapteurId(mesure.getCapteurId());

            if (parcelles.isEmpty()) {
                System.out.println("Aucune parcelle associée au capteur " + mesure.getCapteurId());
                return;
            }

            parcelles.forEach(parcelle -> {
                if (mesure.getValeur() != null && mesure.getValeur() < parcelle.getSeuilHumiditeMin()) {
                    ActionIrrigationDTO action = new ActionIrrigationDTO();
                    action.setParcelleId(parcelle.getId());
                    action.setDateDebut(LocalDateTime.now());
                    action.setDuree(1.0);
                    action.setVolumeEau(100.0);
                    action.setStatut("EN_COURS");
                    actionService.save(action);

                    System.out.println("Irrigation déclenchée pour la parcelle: " + parcelle.getNom());
                }
            });
        } catch (Exception e) {
            System.err.println("Erreur lors du traitement de la mesure : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
