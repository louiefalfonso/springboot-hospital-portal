package hospitalportal_app.hospitalportal.repository;


import hospitalportal_app.hospitalportal.entity.Patient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class PatientRepositoryTest {

    @Autowired
   private PatientRepository patientRepository;

    //JUnit Test for Get Patient
    @Test
    public void getPatientTest() {

        // Create a patient with ID 1L if it doesn't exist
        Patient patient = patientRepository.findById(1L).orElseGet(() -> {
            Patient newPatient = new Patient();
            newPatient.setId(1L);
            return patientRepository.save(newPatient);
        });

        // Verify that the retrieved patient's ID is 1L
        Assertions.assertThat(patient.getId()).isEqualTo(1L);
    }

    //JUnit Test for Get All Patients
    @Test
    public void  getListOfPatientsTest(){
        List<Patient> patients = patientRepository.findAll();
        Assertions.assertThat(patients.size()).isGreaterThan(0);
    }

    @Test
    public void savePatientTest(){
        Patient patient = Patient.builder()
                .fullName("Mitchel Lowe")
                .email("mitchellowe@yahoo.com")
                .number("(0191) 403 5384")
                .sex("Male")
                .age("54")
                .address("11 Phalp Street South Hetton DH6 2SS")
                .diagnosis("Rheumatoid lung disease with rheumatoid arthritis of unspecified site")
                .build();

        Patient savedPatient = patientRepository.save(patient);
        Assertions.assertThat(savedPatient.getId()).isGreaterThan(0);
    }

    //JUnit Test for Update Patient
    @Test
    public void updatePatient(){
        Patient patient = patientRepository.findAllById(1L).get();

        patient.setFullName("Daniel Brookes");
        patient.setEmail("danielbrk@yahoo.com");
        patient.setNumber("(0191) 403 5384");
        patient.setSex("Male");
        patient.setAge("39");
        patient.setAddress("11 Phalp Street South Hetton DH6 2SS");
        patient.setDiagnosis("Rheumatoid lung disease with rheumatoid arthritis of unspecified site");

        Patient patientUpdated = patientRepository.save(patient);

        Assertions.assertThat(patientUpdated.getFullName()).isEqualTo("Daniel Brookes");
        Assertions.assertThat(patientUpdated.getEmail()).isEqualTo("danielbrk@yahoo.com");
        Assertions.assertThat(patientUpdated.getNumber()).isEqualTo("(0191) 403 5384");
        Assertions.assertThat(patientUpdated.getSex()).isEqualTo("Male");
        Assertions.assertThat(patientUpdated.getAge()).isEqualTo("39");
        Assertions.assertThat(patientUpdated.getAddress()).isEqualTo("11 Phalp Street South Hetton DH6 2SS");
        Assertions.assertThat(patientUpdated.getDiagnosis()).isEqualTo("Rheumatoid lung disease with rheumatoid arthritis of unspecified site");

    }
    //JUnit Test for Patient Not Found
    @Test
    public void patientNotFoundTest() {
        // Try to find a patient with an ID that doesn't exist
        Optional<Patient> patientOptional = patientRepository.findById(999L);

        // Verify that the patient is not found
        Assertions.assertThat(patientOptional).isEmpty();
    }



    //JUnit Test for Patient Not Found - NoSuchElementException
    @Test
    public void patientNotFoundNoSuchElementExceptionTest() {
        // Try to find a patient with an ID that doesn't exist
        Optional<Patient> patientOptional = patientRepository.findById(999L);

        // Verify that a NoSuchElementException is thrown when trying to get the patient
        Assertions.assertThatThrownBy(patientOptional::get)
                .isInstanceOf(NoSuchElementException.class);
    }




    //JUnit Test for Delete Patient
    @Test
    public void deletePatientTest(){
        Patient patient = patientRepository.findById(1L).get();

        patientRepository.deleteById(1L);
        Patient patient1 = null;
        Optional<Patient> optionalPatient = patientRepository.findByEmail("danielbrk@yahoo.com");

        if (optionalPatient.isPresent()){
            patient1 = optionalPatient.get();
        }
        Assertions.assertThat(patient1).isNull();
    }



    //JUnit Test for Find All Patients
    @Test
    public void findAllPatientsTest(){
        List<Patient> patients = patientRepository.findAll();
        Assertions.assertThat(patients).isNotEmpty();
        Assertions.assertThat(patients.size()).isGreaterThan(0);
    }



    //JUnit Test for Patient Builder
    @Test
    public void builderTest() {
        // Create a new patient using the builder
        Patient patient = Patient.builder()
                .fullName("Daniel Brookes")
                .email("danielbrk@yahoo.com")
                .number("(0191) 403 5384")
                .sex("Male")
                .age("39")
                .address("11 Phalp Street South Hetton DH6 2SS")
                .diagnosis("Rheumatoid lung disease with rheumatoid arthritis of unspecified site")
                .build();

        // Verify that the patient's fields are set correctly
        Assertions.assertThat(patient.getFullName()).isEqualTo("Daniel Brookes");
        Assertions.assertThat(patient.getEmail()).isEqualTo("danielbrk@yahoo.com");
        Assertions.assertThat(patient.getNumber()).isEqualTo("(0191) 403 5384");
        Assertions.assertThat(patient.getSex()).isEqualTo("Male");
        Assertions.assertThat(patient.getAge()).isEqualTo("39");
        Assertions.assertThat(patient.getAddress()).isEqualTo("11 Phalp Street South Hetton DH6 2SS");
        Assertions.assertThat(patient.getDiagnosis()).isEqualTo("Rheumatoid lung disease with rheumatoid arthritis of unspecified site");
    }

    @Test
    public void toStringTest() {
        Patient patient = Patient.builder()
                .id(1L)
                .fullName("Daniel Brookes")
                .email("danielbrk@yahoo.com")
                .number("(0191) 403 5384")
                .sex("Male")
                .age("39")
                .address("11 Phalp Street South Hetton DH6 2SS")
                .type("In-Patient")
                .diagnosis("Rheumatoid lung disease with rheumatoid arthritis of unspecified site")
                .build();

        String expectedToString = "Patient(id=1, fullName=Daniel Brookes, email=danielbrk@yahoo.com, number=(0191) 403 5384, sex=Male, age=39, address=11 Phalp Street South Hetton DH6 2SS, diagnosis=Rheumatoid lung disease with rheumatoid arthritis of unspecified site, type=In-Patient)";

        Assertions.assertThat(patient.toString()).isEqualTo(expectedToString);
    }

}
