package sharpStore.services.api;

import sharpStore.models.bindingModels.AddMessage;
import sharpStore.models.viewModels.ShowMessage;
import java.util.List;

public interface MessageService {

    void addMessage(AddMessage addMessage);

    List<ShowMessage> findAllMessages();

    ShowMessage findMessageById(Long id);
}
