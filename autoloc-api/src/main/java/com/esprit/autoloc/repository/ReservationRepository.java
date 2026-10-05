package com.esprit.autoloc.repository;

import com.esprit.autoloc.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
