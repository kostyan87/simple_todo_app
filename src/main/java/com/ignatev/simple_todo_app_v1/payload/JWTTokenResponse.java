package com.ignatev.simple_todo_app_v1.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JWTTokenResponse {
    private boolean success;
    private String token;
}
