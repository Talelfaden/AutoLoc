package com.esprit.autoloc.controller;

import com.esprit.autoloc.domain.Client;
import com.esprit.autoloc.service.strategy.IClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Gestion des clients de location")
public class ClientController {
    private final IClientService clientService;

    public ClientController(IClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @Operation(summary = "Lister les clients")
    @ApiResponse(responseCode = "200", description = "Liste des clients récupérée")
    public List<Client> getAll() {
        return clientService.retrieveAllClients();
    }

    @GetMapping("/{id}")
        @Operation(summary = "Rechercher un client")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client trouvé"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
        })
    public ResponseEntity<Client> getById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(clientService.retrieveClient(id));
    }

    @PostMapping
    @Operation(summary = "Créer un client")
    @ApiResponse(responseCode = "200", description = "Client créé")
    public Client create(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/{id}")
        @Operation(summary = "Modifier un client")
        @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Client modifié"),
            @ApiResponse(responseCode = "404", description = "Client introuvable")
        })
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client) {
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    @ApiResponse(responseCode = "204", description = "Client supprimé")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
