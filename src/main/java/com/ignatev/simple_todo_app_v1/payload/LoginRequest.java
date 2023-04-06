package com.ignatev.simple_todo_app_v1.payload;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "email cannot be empty")
    private String email;
    @NotBlank(message = "password cannot be empty")
    private String password;
}
