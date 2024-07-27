package com.task_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // Changed to Long
    private String title;
    private String description;
    private LocalDateTime deadline; // Changed to LocalDateTime
    private boolean completed;
    private String assignedTo;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", deadline=" + deadline
                + ", completed=" + completed + ", assignedTo=" + assignedTo + "]";
    }
}
