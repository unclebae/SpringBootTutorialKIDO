package com.example.demo.todos;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    @Qualifier("todoRepositoryMemImpl")
    private TodoRepository todoRepository;

    @Override
    public Integer addTodo(String actionItem) {
        return todoRepository.addTodo(actionItem);
    }

    @Override
    public void modifyTodo(Integer id, String actionItem) {
        todoRepository.modifyTodo(id, actionItem);
    }

    @Override
    public void toggleTodo(Integer id) {
        todoRepository.toggleTodo(id);
    }

    @Override
    public Todo getTodo(Integer id) {
        return todoRepository.getTodo(id);
    }

    @Override
    public void deleteTodo(Integer id) {
        todoRepository.deleteTodo(id);
    }

    @Override
    public Map<Integer, Todo> getAll() {
        return todoRepository.getAll();
    }

}