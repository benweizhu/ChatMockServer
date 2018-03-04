package me.zeph.bot.service;

import me.zeph.bot.model.Message;
import me.zeph.bot.model.Messages;
import me.zeph.bot.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    public Messages getMessagesByUsername(String username) {
        return messagesRepository.findByUsername(username);
    }

    public Messages saveMessagesByUsername(String username, Message message) {
        Messages messages = messagesRepository.findByUsername(username);
        messages.getMessages().add(message);
        return messagesRepository.save(messages);
    }
}
