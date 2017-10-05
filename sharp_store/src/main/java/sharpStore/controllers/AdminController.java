package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.ModelAttribute;
import mvcFramework.annotations.parameters.PathVariable;
import mvcFramework.annotations.parameters.RequestParam;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.model.Model;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;
import sharpStore.enums.OrderStatus;
import sharpStore.models.ReplyMessage;
import sharpStore.models.bindingModels.AddKnife;
import sharpStore.models.viewModels.ShowKnife;
import sharpStore.models.viewModels.ShowMessage;
import sharpStore.models.viewModels.ShowOrder;
import sharpStore.models.viewModels.ShowUser;
import sharpStore.services.api.KnifeService;
import sharpStore.services.api.MessageService;
import sharpStore.services.api.OrderService;
import sharpStore.staticData.EmailConfig;
import sharpStore.utils.LoggedInUtil;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Stateless
@Controller
public class AdminController {

    @Inject
    private KnifeService knifeService;

    @Inject
    private OrderService orderService;

    @Inject
    private MessageService messageService;

    @Inject
    private HttpSession session;

    private Mailer mailer;

    public AdminController() {
        this.mailer = new Mailer(
                EmailConfig.host, EmailConfig.port,
                EmailConfig.email, EmailConfig.password,
                TransportStrategy.SMTP_SSL);
    }

    @GetMapping("/home/products/add")
    public String getAddProductPage(Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        model.addAttribute("title", "Add Knife");
        model.addAttribute("view", "add-product.jsp");
        return "base-layout";
    }

    @PostMapping("/home/products/add")
    public String addProduct(@ModelAttribute AddKnife addKnife) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        if (addKnife == null) {
            return "redirect:/home/products/add";
        }

        String knifeName = addKnife.getName();
        BigDecimal knifePrice = addKnife.getPrice();
        String imageURL = addKnife.getImageURL();
        if ((knifeName == null || knifeName.trim().isEmpty()) ||
                (knifePrice == null || knifePrice.compareTo(new BigDecimal("0.01")) <= 0) ||
                (imageURL == null || imageURL.trim().isEmpty())) {
            return "redirect:/home/products/add";
        }

        this.knifeService.addKnife(addKnife);
        return "redirect:/home/products";
    }

    @GetMapping("/home/products/edit/{id}")
    public String getEditProductPage(@PathVariable("id") Long id, Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        ShowKnife showKnife = this.knifeService.findKnifeById(id);
        if (showKnife == null) {
            return "redirect:/home/products";
        }

        model.addAttribute("title", "Edit Knife");
        model.addAttribute("knife", showKnife);
        model.addAttribute("view", "edit-product.jsp");
        return "base-layout";
    }

    @PostMapping("/home/products/edit/{id}")
    public String editProduct(@PathVariable("id") Long id,
                              @ModelAttribute ShowKnife editKnife) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        if (editKnife == null) {
            return "redirect:/home/products/edit/" + id;
        }

        String knifeName = editKnife.getName();
        BigDecimal knifePrice = editKnife.getPrice();
        String imageURL = editKnife.getImageURL();
        if ((knifeName == null || knifeName.trim().isEmpty()) ||
                (knifePrice == null || knifePrice.compareTo(new BigDecimal("0.01")) <= 0) ||
                (imageURL == null || imageURL.trim().isEmpty())) {
            return "redirect:/home/products/edit/" + id;
        }

        editKnife.setId(id);
        this.knifeService.editKnife(editKnife);
        return "redirect:/home/products";
    }

    @GetMapping("/home/products/delete/{id}")
    public String getDeleteProductPage(@PathVariable("id") Long id,
                                       Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        ShowKnife showKnife = this.knifeService.findKnifeById(id);
        if (showKnife == null) {
            return "redirect:/home/products";
        }

        model.addAttribute("title", "Delete Knife");
        model.addAttribute("knife", showKnife);
        model.addAttribute("view", "delete-product.jsp");
        return "base-layout";
    }

    @PostMapping("/home/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        this.knifeService.deleteKnife(id);
        return "redirect:/home/products";
    }

    @GetMapping("/home/messages")
    public String getAllMessagesPage(Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        List<ShowMessage> messages = this.messageService.findAllMessages();
        model.addAttribute("title", "All Messages");
        model.addAttribute("messages", messages);
        model.addAttribute("view", "messages.jsp");
        return "base-layout";
    }

    @GetMapping("/home/messages/reply/{id}")
    public String getReplyMessagePage(@PathVariable("id") Long id, Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        ShowMessage message = this.messageService.findMessageById(id);
        if (message == null) {
            return "redirect:/home/messages";
        }

        model.addAttribute("title", "Reply Message");
        model.addAttribute("message", message);
        model.addAttribute("view", "reply-message.jsp");
        return "base-layout";
    }

    @PostMapping("/home/messages/reply/{id}")
    public String replyMessage(@PathVariable("id") Long id,
                               @ModelAttribute ReplyMessage replyMessage) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        if (replyMessage == null) {
            return "redirect:/home/messages/reply/" + id;
        }

        String recipient = replyMessage.getRecipient();
        String subject = replyMessage.getSubject();
        String content = replyMessage.getContent();

        if ((recipient == null || recipient.trim().isEmpty()) ||
                (subject == null || subject.trim().isEmpty()) ||
                (content == null || content.trim().isEmpty())) {
            return "redirect:/home/messages/reply/" + id;
        }

        ShowUser loginModel = (ShowUser) this.session.getAttribute("loginModel");
        String username = loginModel.getUsername();

        // Use external library(SimpleJavaMail) to send message
        Email email = new EmailBuilder()
                .from(username, EmailConfig.email)
                .to(recipient, recipient)
                .subject(subject)
                .text(content)
                .build();
        this.mailer.sendMail(email, true);

        return "redirect:/home/messages";
    }

    @GetMapping("/home/orders")
    public String getAllOrdersPage(Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        List<ShowOrder> orders = this.orderService.findAllOrders();
        model.addAttribute("title", "All Orders");
        model.addAttribute("orders", orders);
        model.addAttribute("view", "orders.jsp");
        return "base-layout";
    }

    @GetMapping("/home/orders/details/{id}")
    public String getOrderDetailsPage(@PathVariable("id") Long id,
                                      Model model) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        ShowOrder order = this.orderService.findOrderById(id);
        if (order == null) {
            return "redirect:/home/orders";
        }

        model.addAttribute("title", "Order Details");
        model.addAttribute("ordersStatus", OrderStatus.values());
        model.addAttribute("order", order);
        model.addAttribute("view", "order-details.jsp");
        return "base-layout";
    }

    @PostMapping("/home/orders/details/{id}")
    public String editOrderDetails(@PathVariable("id") Long id,
                                   @RequestParam("orderStatus") String orderStatusStr) {
        if (!LoggedInUtil.isUserAdmin(this.session)) {
            return "redirect:/home/login";
        }

        ShowOrder order = this.orderService.findOrderById(id);
        if (order == null || (orderStatusStr == null || orderStatusStr.trim().isEmpty())) {
            return "redirect:/home/orders";
        }

        OrderStatus orderStatus;
        try {
            orderStatus = OrderStatus.valueOf(orderStatusStr.toUpperCase());
        } catch (IllegalArgumentException iae) {
            return "redirect:/home/orders";
        }

        order.setStatus(orderStatus);
        this.orderService.editOrder(order);
        return "redirect:/home/orders";
    }
}
