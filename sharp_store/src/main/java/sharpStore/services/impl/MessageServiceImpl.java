package sharpStore.services.impl;

import sharpStore.entities.Message;
import sharpStore.models.bindingModels.AddMessage;
import sharpStore.models.viewModels.ShowMessage;
import sharpStore.repositories.impl.MessageRepositoryImpl;
import sharpStore.services.api.MessageService;
import sharpStore.utils.MapperUtil;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@Local(MessageService.class)
public class MessageServiceImpl implements MessageService {

    @Override
    public void addMessage(AddMessage addMessage) {
        if (addMessage != null) {
            Message message = MapperUtil.getInstance().getModelMapper()
                    .map(addMessage, Message.class);
            MessageRepositoryImpl.getInstance().addMessage(message);
        }
    }

    @Override
    public List<ShowMessage> findAllMessages() {
        List<Message> messages = MessageRepositoryImpl.getInstance().findAllMessages();
        List<ShowMessage> showMessages = MapperUtil.getInstance()
                .convertAll(messages, ShowMessage.class);
        return showMessages;
    }

    @Override
    public ShowMessage findMessageById(Long id) {
        ShowMessage showMessage = null;

        if (id != null) {
            Message message = MessageRepositoryImpl.getInstance()
                    .findMessageById(id);
            if (message != null) {
                showMessage = MapperUtil.getInstance().getModelMapper()
                        .map(message, ShowMessage.class);
            }
        }

        return showMessage;
    }
}
