package com.lucaskruk.todowebapp.controllers;

import com.lucaskruk.todowebapp.models.Task;
import com.lucaskruk.todowebapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    @Autowired
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> get(){
        return taskService.getAllTasks();
    }

    @PostMapping("/task")
    public Task save(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping("/task/{id}")
    public Task get(@PathVariable int id) {
        return taskService.getTask(id);
    }

    @DeleteMapping("/task/{id}")
    public String delete(@PathVariable int id) {
        taskService.deleteTask(id);
        return "Task with id: " + id + " deleted.";
    }
}
