package hospitalportal_app.hospitalportal.repository;

import hospitalportal_app.hospitalportal.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findAllById (Long PatientId);

    // for JUnit Test Case Only
    Optional<Patient> findByEmail(String mail);
}
