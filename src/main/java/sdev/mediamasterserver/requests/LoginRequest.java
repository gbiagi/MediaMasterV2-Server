package sdev.mediamasterserver.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok annotation to generate getters, setters, toString, etc.
@Builder // Lombok annotation to implement the builder pattern and build the objects
@AllArgsConstructor // Lombok annotation to generate an all-arguments constructor
@NoArgsConstructor // Lombok annotation to generate a no-argument constructor
public class LoginRequest {
    private String username;
    private String password;
}
