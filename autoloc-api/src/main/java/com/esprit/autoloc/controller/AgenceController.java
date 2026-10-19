package com.esprit.autoloc.controller;

import com.esprit.autoloc.domain.Agence;
import com.esprit.autoloc.service.strategy.IAgenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agences")
@Tag(name = "Agences", description = "Gestion des agences de location")
public class AgenceController {
    private final IAgenceService agenceService;

    public AgenceController(IAgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @GetMapping
    @Operation(summary = "Lister les agences")
    @ApiResponse(responseCode = "200", description = "Liste des agences récupérée")
    public List<Agence> getAll() {
        return agenceService.retrieveAllAgences();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Rechercher une agence")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence trouvée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
        })
    public ResponseEntity<Agence> getById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(agenceService.retrieveAgence(id));
    }

    @PostMapping
    @Operation(summary = "Créer une agence")
    @ApiResponse(responseCode = "200", description = "Agence créée")
    public Agence create(@RequestBody Agence agence) {
        return agenceService.addAgence(agence);
    }

    @PutMapping("/{id}")
        @Operation(summary = "Modifier une agence")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Agence modifiée"),
            @ApiResponse(responseCode = "404", description = "Agence introuvable")
        })
    public ResponseEntity<Agence> update(@PathVariable Long id, @RequestBody Agence agence) {
        agence.setIdAgence(id);
        return ResponseEntity.ok(agenceService.updateAgence(agence));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une agence")
    @ApiResponse(responseCode = "204", description = "Agence supprimée")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        agenceService.removeAgence(id);
        return ResponseEntity.noContent().build();
    }
}
