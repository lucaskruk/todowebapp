package com.lucaskruk.todowebapp.services;

import com.lucaskruk.todowebapp.models.Task;
import com.lucaskruk.todowebapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        Task t = taskRepository.save(task);
        return t;
    }

    @Override
    public Task updateTask(Task task) {
        Task t = taskRepository.save(task);
        return t;
    }

    @Override
    public Task getTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = (List<Task>) taskRepository.findAll();
        return tasks;
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
