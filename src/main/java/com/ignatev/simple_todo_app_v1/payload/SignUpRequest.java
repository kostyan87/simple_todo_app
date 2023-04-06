package com.ignatev.simple_todo_app_v1.payload;

import com.ignatev.simple_todo_app_v1.annotation.PasswordMatches;
import com.ignatev.simple_todo_app_v1.annotation.ValidEmail;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@PasswordMatches
public class SignUpRequest {
    @Email(message = "it should have email format")
    @NotBlank(message = "email cannot be empty")
    @ValidEmail
    private String email;
    @NotBlank(message = "password is not empty")
    @Size(min = 6, message = "password should be minimum of 6 symbols")
    private String password;
    private String confirmPassword;
}
