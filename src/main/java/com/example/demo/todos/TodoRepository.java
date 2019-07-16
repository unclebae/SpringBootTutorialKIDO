package com.example.demo.todos;

import java.util.Map;

public interface TodoRepository {
    public Integer addTodo(String actionItem);

    public void modifyTodo(Integer id, String actionItem);

    public void toggleTodo(Integer id);

    public Todo getTodo(Integer id);

    public void deleteTodo(Integer id);

    public Map<Integer, Todo> getAll();
}