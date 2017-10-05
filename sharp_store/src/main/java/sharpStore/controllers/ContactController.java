package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.ModelAttribute;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.model.Model;
import sharpStore.models.bindingModels.AddMessage;
import sharpStore.models.viewModels.ShowMessage;
import sharpStore.services.api.MessageService;
import sharpStore.utils.LoggedInUtil;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Stateless
public class ContactController {

    @Inject
    private MessageService messageService;

    @Inject
    private HttpSession session;

    @GetMapping("/home/contacts")
    public String getContactsPage(Model model) {
        model.addAttribute("title", "Contacts");
        model.addAttribute("view", "contacts.jsp");
        return "base-layout";
    }

    @PostMapping("/home/contacts")
    public String sendMessage(@ModelAttribute AddMessage addMessage) {
        if (addMessage == null) {
            return "redirect:/home/contacts";
        }

        String sender = addMessage.getSender();
        String subject = addMessage.getSubject();
        String content = addMessage.getContent();

        if ((sender == null || sender.trim().isEmpty()) ||
                (subject == null || subject.trim().isEmpty()) ||
                (content == null || content.trim().isEmpty())) {
            return "redirect:/home/contacts";
        }

        this.messageService.addMessage(addMessage);
        return "redirect:/";
    }
}
