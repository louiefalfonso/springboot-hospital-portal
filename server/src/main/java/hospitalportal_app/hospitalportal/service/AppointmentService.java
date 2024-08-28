package hospitalportal_app.hospitalportal.service;

import hospitalportal_app.hospitalportal.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {

    AppointmentDto createAppointment (AppointmentDto appointmentDto);

    List<AppointmentDto> getAllAppointments();

    AppointmentDto getAppointmentById (Long appointmentId);

    void  deleteAppointment (Long appointmentId);

    AppointmentDto updateAppointment (Long appointmentId, AppointmentDto updateAppointment);
}

