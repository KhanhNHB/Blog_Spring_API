package com.example.blog.model;

public class User {
    private String id;
    private String password;
    private int max_todo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMax_todo() {
        return max_todo;
    }

    public void setMax_todo(int max_todo) {
        this.max_todo = max_todo;
    }
}
