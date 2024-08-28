package hospitalportal_app.hospitalportal.controller;

import hospitalportal_app.hospitalportal.dto.DoctorDto;
import hospitalportal_app.hospitalportal.entity.Doctor;
import hospitalportal_app.hospitalportal.repository.DoctorRepository;
import hospitalportal_app.hospitalportal.service.DoctorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    //POST New Doctor REST API
    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto savedDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    //GET Doctor By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable("id") long id){
        Doctor doctor = doctorRepository.findAllById(id)
                .orElseThrow(()-> new RuntimeException("Doctor does not exist with Id:" + id));
        return  ResponseEntity.ok(doctor);
    }


    //GET All Doctors REST API
    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAllDoctors(){
        List<DoctorDto> doctor = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctor);
    }

    //UPDATE Doctor REST API
    @PutMapping("{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable ("id")  long id,
                                               @RequestBody Doctor doctorDetails){
        Doctor updateDoctor = doctorRepository.findById(id)
                .orElseThrow( ()-> new RuntimeException("Doctor does not exist with id: " + id));
        updateDoctor.setFirstName(doctorDetails.getFirstName());
        updateDoctor.setLastName(doctorDetails.getLastName());
        updateDoctor.setEmail(doctorDetails.getEmail());
        updateDoctor.setNumber(doctorDetails.getNumber());
        updateDoctor.setDepartment(doctorDetails.getDepartment());
        updateDoctor.setSpecialization(doctorDetails.getSpecialization());
        updateDoctor.setSchedule(doctorDetails.getSchedule());

        doctorRepository.save(updateDoctor);
        return ResponseEntity.ok(updateDoctor);
    }

    //DELETE Doctor REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable("id")Long doctorId){
        doctorService.deleteDoctor(doctorId);
        return ResponseEntity.ok("Doctor Deleted Successfully");
    }
}

