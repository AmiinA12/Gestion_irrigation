package com.example.dto;

import java.time.LocalDateTime;


import lombok.Data;

@Data
public class ActionIrrigationDTO {
	private Long id;
    private Long parcelleId;
    private LocalDateTime dateDebut;
    private Double duree;
    private Double volumeEau;
    private String statut;
   
}
