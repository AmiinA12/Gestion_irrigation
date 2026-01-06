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

import com.example.dto.ParcelleDTO;
import com.example.services.ParcelleService;

@RestController
@RequestMapping("/api/parcelles")
public class ParcelleController {

    @Autowired
    private ParcelleService parcelleService;

    @GetMapping
    public List<ParcelleDTO> getAll() {
        return parcelleService.getAll();
    }
    @GetMapping("/{id}")
    public ParcelleDTO getById(@PathVariable Long id) {
        return parcelleService.getById(id);
    }

    @PostMapping
    public ParcelleDTO create(@RequestBody ParcelleDTO dto) {
        return parcelleService.save(dto);
    }
    // READ: by capteur
    @GetMapping("/capteur/{capteurId}")
    public List<ParcelleDTO> getByCapteur(@PathVariable Long capteurId) {
        return parcelleService.getByCapteurId(capteurId);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ParcelleDTO update(@PathVariable Long id, @RequestBody ParcelleDTO dto) {
        return parcelleService.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = parcelleService.delete(id);
        return deleted ? "Parcelle supprimée" : "Parcelle non trouvée";
    }

}
