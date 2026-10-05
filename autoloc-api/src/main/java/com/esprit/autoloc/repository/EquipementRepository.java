package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Equipement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipementRepository extends JpaRepository<Equipement, Long> {
}
