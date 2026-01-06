package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Parcelle;

public interface ParcelleRepository extends JpaRepository<Parcelle, Long>  {
	List<Parcelle> findByCapteurId(Long capteurId);
}
