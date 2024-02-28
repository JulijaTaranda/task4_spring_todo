package com.example.spring_todo.Service;

import com.example.spring_todo.Model.Todo;
import com.example.spring_todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {


    private final TodoRepository todoRepository;


    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    // returns all data from table
    public List<Todo> findAll() {
        return todoRepository.findAllByOrderByCreatedAtDesc(); // Use the sorted method
    }

    // save todos
    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }


    // single todoo
    public Optional<Todo> findById(Long id) {
        return todoRepository.findById(id);
    }

    // delete single todoo
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    // update todoo
    public Todo update(Long id, String title, boolean completed) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid todo id: " + id));

        todo.setTitle(title);
        todo.setCompleted(completed);

        return todoRepository.save(todo);

    }

}