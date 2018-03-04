package me.zeph.bot.controller;

import me.zeph.bot.model.Messages;
import me.zeph.bot.service.MessagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @RequestMapping(value = "/user/{username}/messages", method = GET)
    public Messages getMessages(@PathVariable("username") String username) {
        return messagesService.getMessagesByUsername(username);
    }

}