package com.esprit.autoloc.controller;

import com.esprit.autoloc.domain.Employe;
import com.esprit.autoloc.service.strategy.IEmployeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    private final IEmployeService employeService;

    public EmployeController(IEmployeService employeService) {
        this.employeService = employeService;
    }

    @GetMapping
    public List<Employe> getAll() {
        return employeService.retrieveAllEmployes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employe> getById(@PathVariable Long id) {
        return ResponseEntity.ofNullable(employeService.retrieveEmploye(id));
    }

    @PostMapping
    public Employe create(@RequestBody Employe employe) {
        return employeService.addEmploye(employe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employe> update(@PathVariable Long id, @RequestBody Employe employe) {
        employe.setIdEmploye(id);
        return ResponseEntity.ok(employeService.updateEmploye(employe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeService.removeEmploye(id);
        return ResponseEntity.noContent().build();
    }
}
