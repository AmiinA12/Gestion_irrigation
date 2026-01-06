package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Capteur;

public interface CapteurRepository extends JpaRepository<Capteur, Long> {
	    List<Capteur> findByEtat(String etat);
	    List <Capteur>findByType(String type);
	    List<Capteur> findByLocalisation(String localisation);

}
