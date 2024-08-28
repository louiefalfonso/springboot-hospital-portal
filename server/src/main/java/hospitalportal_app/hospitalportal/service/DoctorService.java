package hospitalportal_app.hospitalportal.service;

import hospitalportal_app.hospitalportal.dto.DoctorDto;

import java.util.List;

public interface DoctorService {

    DoctorDto createDoctor (DoctorDto doctorDto);

    DoctorDto getDoctorById(Long doctorId);

    List<DoctorDto> getAllDoctors();

    DoctorDto updateDoctor(Long doctorId, DoctorDto updateDoctor);

    void deleteDoctor(Long doctorId);
}


