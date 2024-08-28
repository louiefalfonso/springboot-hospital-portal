package hospitalportal_app.hospitalportal.mapper;

import hospitalportal_app.hospitalportal.dto.AppointmentDto;
import hospitalportal_app.hospitalportal.dto.DoctorDto;
import hospitalportal_app.hospitalportal.entity.Appointment;
import hospitalportal_app.hospitalportal.entity.Doctor;

public class AppointmentMapper {

    public static AppointmentDto mapToAppointmentDto(Appointment appointment){
        DoctorDto doctorDto = new DoctorDto(
                appointment.getDoctor().getId(),
                appointment.getDoctor().getFirstName(),
                appointment.getDoctor().getLastName(),
                appointment.getDoctor().getSpecialization(),
                appointment.getDoctor().getDepartment(),
                appointment.getDoctor().getEmail(),
                appointment.getDoctor().getNumber(),
                appointment.getDoctor().getSchedule()
        );

        return new AppointmentDto(
                appointment.getId(),
                appointment.getDate(),
                appointment.getTime(),
                appointment.getStatus(),
                appointment.getComments(),
                doctorDto
        );
    }

    // Convert Appointment DTO to JPA Entity
    public static Appointment mapToAppointment(AppointmentDto appointmentDto){
        Appointment appointment = new Appointment();
        appointment.setId(appointmentDto.getId());
        appointment.setDate(appointmentDto.getDate());
        appointment.setTime(appointmentDto.getTime());
        appointment.setStatus(appointmentDto.getStatus());
        appointment.setComments(appointmentDto.getComments());

        Doctor doctor = new Doctor();
        doctor.setId(appointmentDto.getDoctor().getId());
        appointment.setDoctor(doctor);
        return appointment;
    }
}
