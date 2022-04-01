package com.lucaskruk.todowebapp.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucaskruk.todowebapp.models.Task;


import com.lucaskruk.todowebapp.services.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    TaskService taskService;

    Task TASK_1 = Task.builder()
            .id(1)
            .taskname("Unit test task 1")
            .dueDate(new SimpleDateFormat("yyyyMMdd").parse("20220520"))
            .build();
    Task TASK_2 = Task.builder()
            .id(1)
            .taskname("Unit test task 2")
            .dueDate(new SimpleDateFormat("yyyyMMdd").parse("20220520"))
            .build();
    Task TASK_3 = Task.builder()
            .id(1)
            .taskname("Unit test task 3")
            .dueDate(new SimpleDateFormat("yyyyMMdd").parse("20220520"))
            .build();

    public TaskControllerTest() throws ParseException {
    }

    @Test
    public void getAllTasks_success() throws Exception {
        List<Task> tasks = new ArrayList<>(Arrays.asList(TASK_1,TASK_2,TASK_3));

        Mockito.when(taskService.getAllTasks()).thenReturn(tasks);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
               .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
}
