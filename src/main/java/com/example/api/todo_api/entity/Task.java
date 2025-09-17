package com.example.api.todo_api.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Task {
    @Id
    private int id;
    
    private String task_name;
    
    private String task_detail;
}