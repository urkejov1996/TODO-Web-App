package com.springboot.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService {


    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        todos.add(new Todo(++todosCount, "Uros", "Learn AWS  1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Uros", "Learn DevOps  1", LocalDate.now().plusYears(2), false));
        todos.add(new Todo(++todosCount, "Uros", "Learn Spring Cloud  1", LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "Uros", "Learn Docker  1", LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String description, String username, LocalDate targetDate, boolean done) {
        todos.add(new Todo(++todosCount, username, description, targetDate, false));
    }

    public void deleteById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        return todos.stream().filter(predicate).findFirst().get();
    }

    public void updateTodo(Todo todo) {
        deleteById(todo.getId());
        todos.add(todo);
    }
}
