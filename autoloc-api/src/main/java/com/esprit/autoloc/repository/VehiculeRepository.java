package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
}
