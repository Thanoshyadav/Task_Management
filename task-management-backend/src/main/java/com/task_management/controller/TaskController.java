package com.task_management.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.task_management.model.Task;
import com.task_management.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable long id, @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @PatchMapping("/{id}/complete")
    public Task markTaskCompleted(@PathVariable long id) {
        return taskService.markTaskCompleted(id);
    }
}
