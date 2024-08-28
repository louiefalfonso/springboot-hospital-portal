package hospitalportal_app.hospitalportal.repository;

import hospitalportal_app.hospitalportal.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    Optional<Appointment> findAllById (Long doctorId);
}

