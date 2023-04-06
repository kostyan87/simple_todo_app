package com.ignatev.simple_todo_app_v1.service;

import com.ignatev.simple_todo_app_v1.dto.TaskDto;
import com.ignatev.simple_todo_app_v1.entity.Task;
import com.ignatev.simple_todo_app_v1.entity.User;
import com.ignatev.simple_todo_app_v1.exception.TaskNotFoundException;
import com.ignatev.simple_todo_app_v1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(TaskDto taskDto, User user) {
        Task task = new Task();
        task.setUser(user);
        task.setTitle(taskDto.getTitle());
        task.setDone(taskDto.isDone());

        return taskRepository.save(task);
    }

    public List<Task> getAllTaskForUser(User user) {
        return taskRepository.getTasksByUser(user);
    }

    public Task deleteTask(Long id, User user) {
        Task task = getTaskByIdAndUser(id, user);

        taskRepository.delete(task);

        return task;
    }

    public Task updateTask(Long id, User user) {
        Task task = getTaskByIdAndUser(id, user);

        task.setDone(!task.isDone());

        return taskRepository.save(task);
    }

    public Task getTaskByIdAndUser(Long id, User user) {
        return taskRepository
                .findByIdAndUser(id, user)
                .orElseThrow(() -> new TaskNotFoundException("There is no tasks with id=" + id));
    }
}
