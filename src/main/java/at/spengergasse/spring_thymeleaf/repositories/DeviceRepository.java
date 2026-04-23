package at.spengergasse.spring_thymeleaf.repositories;

import at.spengergasse.spring_thymeleaf.entities.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}