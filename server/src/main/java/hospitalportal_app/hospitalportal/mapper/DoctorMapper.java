package hospitalportal_app.hospitalportal.mapper;

import hospitalportal_app.hospitalportal.dto.DoctorDto;
import hospitalportal_app.hospitalportal.entity.Doctor;

public class DoctorMapper {
    // Convert Doctor JPA Entity to DTO
    public static DoctorDto mapToDoctorDto(Doctor doctor){
        return new DoctorDto(
                doctor.getId(),
                doctor.getFirstName(),
                doctor.getLastName(),
                doctor.getEmail(),
                doctor.getNumber(),
                doctor.getDepartment(),
                doctor.getSpecialization(),
                doctor.getSchedule()
        );
    }

    // Convert Doctor DTO to JPA Entity
    public static Doctor mapToDoctor(DoctorDto doctorDto){
        return new Doctor(
                doctorDto.getId(),
                doctorDto.getFirstName(),
                doctorDto.getLastName(),
                doctorDto.getEmail(),
                doctorDto.getNumber(),
                doctorDto.getDepartment(),
                doctorDto.getSpecialization(),
                doctorDto.getSchedule()
        );
    }

}
