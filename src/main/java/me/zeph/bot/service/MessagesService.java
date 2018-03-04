package me.zeph.bot.service;

import me.zeph.bot.model.Message;
import me.zeph.bot.model.Messages;
import me.zeph.bot.model.User;
import me.zeph.bot.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessagesService {

    @Value("${chat.bot.avatar}")
    private String avatar;

    @Value("${chat.bot.name}")
    private String botName;

    @Autowired
    private MessagesRepository messagesRepository;

    public Messages getMessagesByUsername(String username) {
        return messagesRepository.findByUsername(username);
    }

    public Messages saveMessagesFromUserAndBot(String username, Message message, String botReply) {
        Messages messages = messagesRepository.findByUsername(username);
        messages.getMessages().add(message);
        messages.getMessages().add(getBotMessage(botReply));
        return messagesRepository.save(messages);
    }

    private Message getBotMessage(String botReply) {
        return new Message("", botReply, new Date(), new User("", botName, avatar));
    }
}
