package hospitalportal_app.hospitalportal.service;

import hospitalportal_app.hospitalportal.dto.LoginDto;
import hospitalportal_app.hospitalportal.dto.RegisterDto;

public interface AuthService {

    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}