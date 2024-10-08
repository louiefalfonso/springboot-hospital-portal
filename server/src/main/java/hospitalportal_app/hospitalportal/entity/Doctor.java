package hospitalportal_app.hospitalportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "number")
    private String number;

    @Column(name = "specialization")
    private String specialization;

    @Column(name= "department")
    private String department;

    @Column(name = "schedule")
    private String schedule;

    public Doctor(Long id) {
        this.id = id;
    }

}


