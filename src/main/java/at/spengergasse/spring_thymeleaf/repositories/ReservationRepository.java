package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}