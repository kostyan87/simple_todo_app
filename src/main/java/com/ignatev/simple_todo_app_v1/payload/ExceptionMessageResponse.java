package com.ignatev.simple_todo_app_v1.payload;

import lombok.Data;

@Data
public class ExceptionMessageResponse {
    private String message;

    public ExceptionMessageResponse(String message) {
        this.message = message;
    }
}
