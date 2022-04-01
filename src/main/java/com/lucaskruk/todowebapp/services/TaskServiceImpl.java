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
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(int id, Task task) {
        Task taskFromDB = taskRepository.findById(id).get();
        taskFromDB.setTaskname(task.getTaskname());
        taskFromDB.setDueDate(task.getDueDate());
        taskFromDB.setStatus(task.getStatus());
        return taskRepository.save(taskFromDB);
    }

    @Override
    public Task getTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        return task.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) taskRepository.findAll();
    }

    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }
}
