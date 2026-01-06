package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.CapteurDTO;
import com.example.models.Capteur;
import com.example.models.Mesure;
import com.example.services.CapteurService;

@RestController
@RequestMapping("/api/capteurs")
public class CapteurController {
	@Autowired
    private CapteurService capteurService;

    @GetMapping
    public List<CapteurDTO> getAll() {
        return capteurService.getAllCapteurs();
    }

    @GetMapping("/{id}")
    public CapteurDTO getById(@PathVariable Long id) {
        return capteurService.getCapteurById(id);
    }

    @PostMapping
    public CapteurDTO create(@RequestBody CapteurDTO dto) {
        return capteurService.saveCapteur(dto);
    }
    
    @PutMapping("/{id}")
    public CapteurDTO update(@PathVariable Long id,
                             @RequestBody CapteurDTO dto) {
        return capteurService.updateCapteur(id, dto);
    }

    // ===== DELETE =====
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        capteurService.deleteCapteur(id);
        return ResponseEntity.ok("Capteur supprimé avec succès");
    }
    
}
