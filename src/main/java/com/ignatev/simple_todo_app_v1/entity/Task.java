package com.ignatev.simple_todo_app_v1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private boolean isDone;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }
}
