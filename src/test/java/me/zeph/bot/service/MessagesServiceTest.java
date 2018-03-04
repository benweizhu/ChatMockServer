package me.zeph.bot.service;

import me.zeph.bot.Application;
import me.zeph.bot.model.Message;
import me.zeph.bot.model.Messages;
import me.zeph.bot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@ActiveProfiles(value = "test")
public class MessagesServiceTest {

    private static final String USERNAME = "benwei";

    @Autowired
    private MessagesService messagesService;

    @Test
    public void shouldSaveMessage() {
        Messages messages = messagesService.saveMessagesByUsername(USERNAME, getMessage("hi"));
        assertThat(messages.getUsername(), is(USERNAME));
    }

    private Message getMessage(String text) {
        Message message = new Message();
        message.setCreatedAt(new Date());
        message.setUser(getUser());
        message.setText(text);
        return message;
    }

    private User getUser() {
        User user = new User();
        user.setName(USERNAME);
        return user;
    }
}