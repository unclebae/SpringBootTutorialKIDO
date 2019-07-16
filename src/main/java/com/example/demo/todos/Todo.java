package com.example.demo.todos;

public class Todo {
    private Integer id;
    private String actionItem;
    private boolean done;

    public Todo(Integer id, String actionItem, boolean done) {
        this.id = id;
        this.actionItem = actionItem;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionItem() {
        return actionItem;
    }

    public void setActionItem(String actionItem) {
        this.actionItem = actionItem;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "Todo [actionItem=" + actionItem + ", done=" + done + ", id=" + id + "]";
    }

}