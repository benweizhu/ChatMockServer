package me.zeph.bot.service;

import me.zeph.bot.model.Message;
import me.zeph.bot.model.Messages;
import me.zeph.bot.model.User;
import me.zeph.bot.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    public Messages getMessagesByUsername(String username) {
        return messagesRepository.findByUsername(username);
    }

    public Messages saveMessagesFromUserAndBot(String username, Message message, String botReply) {
        Messages messages = messagesRepository.findByUsername(username);
        messages.getMessages().add(message);
        messages.getMessages().add(getMessage(botReply));
        return messagesRepository.save(messages);
    }

    private Message getMessage(String botReply) {
        return new Message("", botReply, new Date(), new User());
    }
}
