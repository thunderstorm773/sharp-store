package sharpStore.repositories.api;

import sharpStore.entities.Message;

import java.util.List;

public interface MessageRepository {

    void addMessage(Message message);

    List<Message> findAllMessages();

    Message findMessageById(Long id);
}
