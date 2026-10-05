package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence, Long> {
}
