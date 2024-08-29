package hospitalportal_app.hospitalportal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
    private String usernameOrEmail;
    private String password;

    public Object getPassword() {
        return password;
    }

    public Object getUsernameOrEmail() {
        return usernameOrEmail;
    }
}
