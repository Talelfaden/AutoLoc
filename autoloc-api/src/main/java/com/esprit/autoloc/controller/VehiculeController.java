package com.esprit.autoloc.controller;

import com.esprit.autoloc.domain.Vehicule;
import com.esprit.autoloc.service.strategy.IVehiculeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
@Tag(name = "Véhicules", description = "Gestion des véhicules de location")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    public VehiculeController(IVehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    @Operation(summary = "Lister les véhicules")
    @ApiResponse(responseCode = "200", description = "Liste des véhicules récupérée")
    public List<Vehicule> getAll() {
        return vehiculeService.retrieveAllVehicules();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Rechercher un véhicule")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule trouvé"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
        })
    public ResponseEntity<Vehicule> getById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(vehiculeService.retrieveVehicule(id));
    }

    @PostMapping
    @Operation(summary = "Créer un véhicule")
    @ApiResponse(responseCode = "200", description = "Véhicule créé")
    public Vehicule create(@RequestBody Vehicule vehicule) {
        return vehiculeService.addVehicule(vehicule);
    }

    @PutMapping("/{id}")
        @Operation(summary = "Modifier un véhicule")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Véhicule modifié"),
            @ApiResponse(responseCode = "404", description = "Véhicule introuvable")
        })
    public ResponseEntity<Vehicule> update(@PathVariable Long id, @RequestBody Vehicule vehicule) {
        vehicule.setIdVehicule(id);
        return ResponseEntity.ok(vehiculeService.updateVehicule(vehicule));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un véhicule")
    @ApiResponse(responseCode = "204", description = "Véhicule supprimé")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        vehiculeService.removeVehicule(id);
        return ResponseEntity.noContent().build();
    }
}
