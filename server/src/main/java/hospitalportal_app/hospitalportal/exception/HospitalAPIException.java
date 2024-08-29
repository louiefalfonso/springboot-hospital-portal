package hospitalportal_app.hospitalportal.exception;

import org.springframework.http.HttpStatus;

public class HospitalAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public HospitalAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HospitalAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
