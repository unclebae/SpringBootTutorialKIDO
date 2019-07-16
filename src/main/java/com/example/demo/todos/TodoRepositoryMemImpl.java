
package com.example.demo.todos;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

@Repository(value = "todoRepositoryMemImpl")
public class TodoRepositoryMemImpl implements TodoRepository {
    private HashMap<Integer, Todo> todoMap = new HashMap<>();

    private AtomicInteger id = new AtomicInteger(1);

    public TodoRepositoryMemImpl() {
        int id01 = id.getAndIncrement();
        todoMap.put(id01, new Todo(id01, "Get up at 6", true));
        int id02 = id.getAndIncrement();
        todoMap.put(id02, new Todo(id02, "Have a breakfast", false));
        int id03 = id.getAndIncrement();
        todoMap.put(id03, new Todo(id03, "Go to work", true));
    }

    public Integer addTodo(String actionItem) {
        Todo newTodo = new Todo(id.getAndIncrement(), actionItem, false);
        todoMap.put(newTodo.getId(), newTodo);
        return newTodo.getId();
    }

    public void modifyTodo(Integer id, String actionItem) {
        Todo todo = todoMap.get(id);
        todo.setActionItem(actionItem);
    }

    public void toggleTodo(Integer id) {
        Todo todo = todoMap.get(id);
        todo.setDone(!todo.isDone());
    }

    public Todo getTodo(Integer id) {
        return todoMap.get(id);
    }

    public void deleteTodo(Integer id) {
        todoMap.remove(id);
    }

    @Override
    public Map<Integer, Todo> getAll() {
        return todoMap;
    }

}