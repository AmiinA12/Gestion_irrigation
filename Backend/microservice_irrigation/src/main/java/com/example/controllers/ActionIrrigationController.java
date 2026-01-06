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

import com.example.dto.ActionIrrigationDTO;
import com.example.services.ActionIrrigationService;

@RestController
@RequestMapping("/api/actions")
public class ActionIrrigationController {

    @Autowired
    private ActionIrrigationService actionService;

    @GetMapping
    public List<ActionIrrigationDTO> getAll() {
        return actionService.getAll();
    }

    @PostMapping
    public ActionIrrigationDTO create(@RequestBody ActionIrrigationDTO dto) {
        return actionService.save(dto);
    }
    

    // READ: by ID
    @GetMapping("/{id}")
    public ActionIrrigationDTO getById(@PathVariable Long id) {
        return actionService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ActionIrrigationDTO update(@PathVariable Long id, @RequestBody ActionIrrigationDTO dto) {
        return actionService.update(id, dto);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        boolean deleted = actionService.delete(id);
        return deleted ? "Action supprimée" : "Action non trouvée";
    }

}
