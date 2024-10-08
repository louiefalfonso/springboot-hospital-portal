package hospitalportal_app.hospitalportal.controller;

import hospitalportal_app.hospitalportal.dto.PatientDto;
import hospitalportal_app.hospitalportal.entity.Patient;
import hospitalportal_app.hospitalportal.repository.PatientRepository;
import hospitalportal_app.hospitalportal.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;
    private PatientService patientService;

    //POST New Patient REST API
    @PostMapping
    public ResponseEntity<PatientDto> createPatient (@RequestBody PatientDto patientDto){
        PatientDto savedPatient = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedPatient, HttpStatus.CREATED);
    }

    //GET patient By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable("id") long id){
        Patient patient = patientRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Patient does not exist with Id:" + id));
        return ResponseEntity.ok(patient);
    }

    //GET All Patients REST API
    @GetMapping
    public ResponseEntity<List<PatientDto>> getAllPatients(){
        List<PatientDto> patient = patientService.getAllPatients();
        return ResponseEntity.ok(patient);
    }

    //UPDATE Patient REST API
    @PutMapping("{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable ("id") long id,
                                                 @RequestBody Patient patientDetails){
        Patient updatePatient = patientRepository.findById(id)
                .orElseThrow( ()-> new RuntimeException("Patient does not exist with id: " + id));

        updatePatient.setFullName(patientDetails.getFullName());
        updatePatient.setAge(patientDetails.getAge());
        updatePatient.setSex(patientDetails.getSex());
        updatePatient.setEmail(patientDetails.getEmail());
        updatePatient.setNumber(patientDetails.getNumber());
        updatePatient.setAddress(patientDetails.getAddress());
        updatePatient.setDiagnosis(patientDetails.getDiagnosis());
        updatePatient.setType(patientDetails.getType());

        patientRepository.save(updatePatient);
        return ResponseEntity.ok(updatePatient);
    }

    //DELETE Patient REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id")Long patientId){
        patientService.deletePatient(patientId);
        return ResponseEntity.ok("Patient Deleted Successfully");
    }


}

