package me.zeph.bot.service;

import me.zeph.bot.model.Messages;
import me.zeph.bot.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    public Messages getMesssagesByUsername(String username) {
        return messagesRepository.findByUsername(username);
    }

}
