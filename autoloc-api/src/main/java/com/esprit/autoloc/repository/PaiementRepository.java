package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
