package com.example.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.models.Mesure;

import feign.Param;

public interface MesureRepository extends JpaRepository<Mesure, Long> {
	List<Mesure> findByCapteurId(Long capteurId);

    @Query("SELECT m FROM Mesure m WHERE m.capteurId = :id ORDER BY m.dateMesure DESC")
    List<Mesure> findLatestByCapteurId(@Param("id") Long id);
}
