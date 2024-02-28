package com.example.spring_todo.Repository;

import com.example.spring_todo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findAllByOrderByCreatedAtDesc(); // Sort by createdAt in descending order

}






