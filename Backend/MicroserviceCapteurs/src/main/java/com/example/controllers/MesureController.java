package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MesureDTO;
import com.example.models.Mesure;
import com.example.services.MesureService;

@RestController
@RequestMapping("/api/mesures")
public class MesureController {
	 @Autowired
	    private MesureService mesureService;

	    @PostMapping
	    public MesureDTO create(@RequestBody MesureDTO dto) {
	        return mesureService.save(dto);
	    }

	    @GetMapping("/latest/{capteurId}")
	    public MesureDTO getLatest(@PathVariable Long capteurId) {
	        return mesureService.getLatest(capteurId);
	    }
	    // READ: all by capteur
	    @GetMapping("/capteur/{capteurId}")
	    public List<MesureDTO> getAllByCapteur(@PathVariable Long capteurId) {
	        return mesureService.getAllByCapteur(capteurId);
	    }

	    // UPDATE
	    @PutMapping("/{id}")
	    public MesureDTO update(@PathVariable Long id, @RequestBody MesureDTO dto) {
	        return mesureService.update(id, dto);
	    }

	    // DELETE
	    @DeleteMapping("/{id}")
	    public String delete(@PathVariable Long id) {
	        boolean deleted = mesureService.delete(id);
	        return deleted ? "Mesure supprimée" : "Mesure non trouvée";
	    }
}
