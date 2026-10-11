package com.esprit.autoloc.controller;

import com.esprit.autoloc.domain.Contrat;
import com.esprit.autoloc.service.strategy.IContratService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contrats")
public class ContratController {
    private final IContratService contratService;

    public ContratController(IContratService contratService) {
        this.contratService = contratService;
    }

    @GetMapping
    public List<Contrat> getAll() {
        return contratService.retrieveAllContrats();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(contratService.retrieveContrat(id));
    }

    @PostMapping
    public Contrat create(@RequestBody Contrat contrat) {
        return contratService.addContrat(contrat);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrat> update(@PathVariable Long id, @RequestBody Contrat contrat) {
        contrat.setIdContrat(id);
        return ResponseEntity.ok(contratService.updateContrat(contrat));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        contratService.removeContrat(id);
        return ResponseEntity.noContent().build();
    }
}
