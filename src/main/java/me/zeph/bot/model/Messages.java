package me.zeph.bot.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Messages {

    @Id
    private String id;
    private String username;
    private List<Message> messages;

    public Messages() {
    }

    public Messages(String id, String username, List<Message> messages) {
        this.id = id;
        this.username = username;
        this.messages = messages;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
