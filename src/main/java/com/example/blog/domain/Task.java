package com.example.blog.domain;

import java.util.Date;
import java.util.UUID;

public class Task {
    private final UUID id;
    private String content;
    private String userId;
    private Date createdDate;

    public Task(UUID id, String content, String userId, Date createdDate) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.createdDate = createdDate;
    }

    public UUID getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
