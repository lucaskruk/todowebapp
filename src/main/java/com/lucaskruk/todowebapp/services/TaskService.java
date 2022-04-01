package com.lucaskruk.todowebapp.services;

import com.lucaskruk.todowebapp.models.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task getTask(int id);

    Task createTask(Task task);

    Task updateTask(Task task);

    void deleteTask(int id);
}
