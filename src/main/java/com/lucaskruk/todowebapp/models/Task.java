package com.lucaskruk.todowebapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name="Task")
@Table(name="task")
public class Task implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name = "taskname", nullable=false)
    private String taskname;

    @Column(name = "duedate")
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dueDate;

    @Column(name = "status")
    private int status;
}
