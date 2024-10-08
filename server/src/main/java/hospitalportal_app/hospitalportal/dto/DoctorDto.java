package hospitalportal_app.hospitalportal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String number;
    private String department;
    private String specialization;
    private String schedule;

    public DoctorDto(Long id, String firstName, String lastName, String specialization, String department, String number, String schedule) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.department = department;
        this.number = number;
        this.schedule = schedule;
    }

    public DoctorDto(int id) {
        this.id = Long.valueOf(id);
    }

}
