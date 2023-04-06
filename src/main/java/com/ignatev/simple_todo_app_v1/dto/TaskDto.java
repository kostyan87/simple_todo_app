package com.ignatev.simple_todo_app_v1.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class TaskDto {
    @NotBlank(message = "title should not be empty")
    private String title;
    private boolean isDone;
}
