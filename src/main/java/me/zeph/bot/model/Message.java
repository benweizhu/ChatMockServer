package me.zeph.bot.model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Message {

    @Id
    private String id;
    private String text;
    private Date createdAt;
    private User user;

    public Message() {
    }

    public Message(String id, String text, Date createdAt, User user) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
