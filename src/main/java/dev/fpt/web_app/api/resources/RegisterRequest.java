package dev.fpt.web_app.api.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class RegisterRequest {

    @NotBlank(message = "UserName cannot be blank")
    private String userName;

    @NotBlank
    @Size(min = 11, max = 74, message = "Email must be between 11 and 74 characters")
    @Pattern(
            regexp = "^[A-Za-z\\d._%+-]{1,64}@gmail\\.com$",
            message = "Only Gmail accounts are allowed"
    )
    private String email;

    @NotBlank
    @Size(min = 8, max = 20, message = "Password must be between 8-20 characters have")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[!@#$%^&*()]).{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;
}

