package me.zeph.bot.repository;

import me.zeph.bot.model.Messages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessagesRepository extends MongoRepository<Messages, String> {
    Messages findByUsername(String username);
}
