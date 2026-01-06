package com.example.dto;

import lombok.Data;

@Data
public class ParcelleDTO {
	 private Long id;
	    private String nom;
	    private Double superficie;
	    private Double seuilHumiditeMin;
	    private Double seuilHumiditeMax;
	    private Long capteurId;
	   
}
