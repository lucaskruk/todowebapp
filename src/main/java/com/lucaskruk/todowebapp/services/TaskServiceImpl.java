package com.lucaskruk.todowebapp.services;

import com.lucaskruk.todowebapp.exceptions.InvalidRequestException;
import com.lucaskruk.todowebapp.exceptions.NotFoundException;
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

        if (task == null) {
            throw new InvalidRequestException("Task to update must not be null");
        }

        Optional<Task> taskFromDB = taskRepository.findById(id);

        if (taskFromDB.isEmpty()) {
            throw new NotFoundException("Task with id: " + id + "does not exists.");
        }
        Task foundTask = taskFromDB.get();
        foundTask.setTaskname(task.getTaskname());
        foundTask.setDueDate(task.getDueDate());
        foundTask.setStatus(task.getStatus());
        return taskRepository.save(foundTask);
    }

    @Override
    public Task getTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new NotFoundException("Task with id: " + id + "does not exists.");
        }
        return task.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void deleteTask(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty()) {
            throw new NotFoundException("Task with id: " + id + "does not exists.");
        }
        taskRepository.deleteById(id);
    }
}
