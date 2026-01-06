package com.example.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class CapteurDTO {
	private Long id;
    private String type;
    private String localisation;
    private String etat;
    private LocalDate dateInstallation;

}
