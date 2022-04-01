package com.lucaskruk.todowebapp.repositories;

import com.lucaskruk.todowebapp.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Integer> {
}
