package com.ignatev.simple_todo_app_v1.repository;

import com.ignatev.simple_todo_app_v1.entity.Task;
import com.ignatev.simple_todo_app_v1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> getTasksByUser(User user);

    Optional<Task> findByIdAndUser(Long id, User user);
}
