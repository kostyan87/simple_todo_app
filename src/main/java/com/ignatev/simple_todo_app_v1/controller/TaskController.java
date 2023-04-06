package com.ignatev.simple_todo_app_v1.controller;

import com.ignatev.simple_todo_app_v1.dto.TaskDto;
import com.ignatev.simple_todo_app_v1.entity.Task;
import com.ignatev.simple_todo_app_v1.entity.User;
import com.ignatev.simple_todo_app_v1.service.TaskService;
import com.ignatev.simple_todo_app_v1.service.UserService;
import com.ignatev.simple_todo_app_v1.validation.ResponseErrorValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private ResponseErrorValidation responseErrorValidation;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> createTask(@Valid @RequestBody TaskDto taskDto,
                                             Principal principal,
                                             BindingResult bindingResult) {
        ResponseEntity<Object> errors = responseErrorValidation.mapValidationService(bindingResult);
        if (!ObjectUtils.isEmpty(errors)) return errors;

        User user = userService.getUserByPrincipal(principal);

        return ResponseEntity.ok(taskService.createTask(taskDto, user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable String id, Principal principal) {
        User user = userService.getUserByPrincipal(principal);

        return ResponseEntity.ok(taskService.deleteTask(Long.parseLong(id), user));
    }

    @PatchMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, Principal principal) {
        User user = userService.getUserByPrincipal(principal);

        return ResponseEntity.ok(taskService.updateTask(Long.parseLong(id), user));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(Principal principal) {
        User user = userService.getUserByPrincipal(principal);

        return ResponseEntity.ok(taskService.getAllTaskForUser(user));
    }
}
