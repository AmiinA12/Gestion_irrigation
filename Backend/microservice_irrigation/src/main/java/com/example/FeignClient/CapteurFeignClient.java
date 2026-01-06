package com.example.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.MesureDTO;



@FeignClient(name = "capteurs-service", url = "http://localhost:8081")
public interface CapteurFeignClient {
	@GetMapping("/api/mesures/latest/{capteurId}")
    MesureDTO getLatestMesure(@PathVariable("capteurId") Long capteurId);

}
