package com.example.demo.todos;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    // Get Todos
    @GetMapping(value = "/todos")
    public Map<Integer, Todo> getAllTodos() {
        return todoService.getAll();
    }

    // Get Todo by Id
    @GetMapping(value = "/todos/{id}")
    public Todo getMethodName(@PathVariable("id") Integer id) {
        return todoService.getTodo(id);
    }

    // Post Todos
    @PostMapping(value = "/todos/todo")
    public Integer addTodo(@RequestBody String actionItem) {
        return todoService.addTodo(actionItem);
    }

    // Put Todos
    @PutMapping(value = "/todos/todo/{id}")
    public String modifyActionItem(@PathVariable Integer id, @RequestBody String actionItem) {
        todoService.modifyTodo(id, actionItem);
        return "OK";
    }

    // toggle Todos
    @PutMapping(value = "/todos/todo/{id}/toggle")
    public String modifyTodoDone(@PathVariable Integer id) {
        todoService.toggleTodo(id);
        return "OK";
    }

    // Delete Todo
    @DeleteMapping(value = "/todos/todo/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
        return "OK";
    }
}