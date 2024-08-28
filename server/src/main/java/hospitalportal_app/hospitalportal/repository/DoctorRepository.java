package hospitalportal_app.hospitalportal.repository;

import hospitalportal_app.hospitalportal.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    Optional<Doctor> findAllById(Long doctorId);

}

