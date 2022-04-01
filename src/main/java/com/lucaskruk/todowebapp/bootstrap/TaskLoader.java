package com.lucaskruk.todowebapp.bootstrap;

import com.lucaskruk.todowebapp.models.Task;
import com.lucaskruk.todowebapp.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;

public class TaskLoader implements CommandLineRunner {
    public final TaskRepository taskRepository;

    public TaskLoader(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void run(String... args){
        loadTasks();
    }

    private void loadTasks(){
        if (taskRepository.count() == 0) {
            taskRepository.save(
                    Task.builder()
                            .id(1)
                            .taskname("sample task")
                            .status(1)
                            .build()
            );
        }
    }
}
