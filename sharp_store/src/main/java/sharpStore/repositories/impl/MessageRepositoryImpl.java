package sharpStore.repositories.impl;

import sharpStore.entities.Message;
import sharpStore.repositories.api.MessageRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MessageRepositoryImpl implements MessageRepository{

    private static MessageRepositoryImpl messageRepository;

    private List<Message> messages;

    private long currentIndex;

    private MessageRepositoryImpl() {
        this.messages = new ArrayList<>();
        this.currentIndex = 1L;
    }

    public static MessageRepository getInstance() {
        if (messageRepository == null) {
            messageRepository = new MessageRepositoryImpl();
        }

        return messageRepository;
    }

    @Override
    public void addMessage(Message message) {
        message.setId(this.currentIndex++);
        this.messages.add(message);
    }

    @Override
    public List<Message> findAllMessages() {
        return this.messages;
    }

    @Override
    public Message findMessageById(Long id) {
        Message message = null;
        Optional<Message> candidateMessage = this.messages.stream()
                .filter(m -> m.getId().equals(id))
                .findAny();

        if (candidateMessage.isPresent()) {
            message = candidateMessage.get();
        }

        return message;
    }
}
