package com.example.api.todo_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.api.todo_api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    
}