
package com.example.demo.todos;

import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository(value = "todoRepositoryDBImpl")
public class TodoRepositoryDBImpl implements TodoRepository {

    @Override
    public Integer addTodo(String actionItem) {
        return null;
    }

    @Override
    public void modifyTodo(Integer id, String actionItem) {

    }

    @Override
    public void toggleTodo(Integer id) {

    }

    @Override
    public Todo getTodo(Integer id) {
        return null;
    }

    @Override
    public void deleteTodo(Integer id) {

    }

    @Override
    public Map<Integer, Todo> getAll() {
        return null;
    }
}