package me.zeph.bot.repository;

import me.zeph.bot.model.Message;
import me.zeph.bot.model.Messages;
import me.zeph.bot.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataMongoTest
@ActiveProfiles(value = "test")
public class MessagesRepositoryTest {

    private static final String USERNAME = "benwei";

    @Autowired
    private MessagesRepository messagesRepository;

    @Before
    public void setUp() {
        messagesRepository.save(getMessages());
    }

    @Test
    public void shouldGetMessagesByUsername() {
        Messages messages = messagesRepository.findByUsername(USERNAME);
        assertThat(messages.getUsername(), is(USERNAME));
    }

    private Messages getMessages() {
        Messages messages = new Messages();
        messages.setUsername(USERNAME);
        messages.setMessages(getMessageList());
        return messages;
    }

    private ArrayList<Message> getMessageList() {
        ArrayList<Message> messageArrayList = new ArrayList<>();
        messageArrayList.add(getMessage("hi"));
        return messageArrayList;
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