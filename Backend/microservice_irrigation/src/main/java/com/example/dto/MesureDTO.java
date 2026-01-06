package com.example.dto;

import java.time.LocalDateTime;



import lombok.Data;

@Data
public class MesureDTO {
	private Long id;
    private Double valeur;
    private String unite;
    private LocalDateTime dateMesure;
    private Long capteurId;
    
    }