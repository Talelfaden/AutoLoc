package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
}
