package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.ModelAttribute;
import mvcFramework.annotations.parameters.PathVariable;
import mvcFramework.annotations.parameters.RequestParam;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.model.Model;
import sharpStore.models.bindingModels.AddOrder;
import sharpStore.models.viewModels.ShowKnife;
import sharpStore.models.viewModels.ShowUser;
import sharpStore.services.api.KnifeService;
import sharpStore.services.api.OrderService;
import sharpStore.utils.LoggedInUtil;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Stateless
public class ProductController {

    @Inject
    private KnifeService knifeService;

    @Inject
    private OrderService orderService;

    @Inject
    private HttpSession session;

    @GetMapping("/home/products")
    public String getProductsPage(@RequestParam("search") String knifeName,
                                  Model model) {
        List<ShowKnife> showKnives;
        if (knifeName != null && !knifeName.trim().isEmpty()) {
            showKnives = this.knifeService.findKnivesByName(knifeName);
        } else {
            showKnives = this.knifeService.findAllKnives();
        }

        model.addAttribute("title", "Products");
        model.addAttribute("view", "products.jsp");
        model.addAttribute("knives", showKnives);
        return "base-layout";
    }

    @GetMapping("/home/products/buy/{id}")
    public String getBuyProductPage(@PathVariable("id") Long id,
                                    Model model) {
        if (!LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/home/login";
        }

        ShowKnife showKnife = this.knifeService.findKnifeById(id);
        if (showKnife == null) {
            return "redirect:/";
        }

        model.addAttribute("title", "Buy Knife");
        model.addAttribute("view", "buy.jsp");
        return "base-layout";
    }

    @PostMapping("/home/products/buy/{id}")
    public String buyProduct(@PathVariable("id") Long id,
                             @ModelAttribute AddOrder addOrder,
                             HttpSession session) {
        if (!LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/home/login";
        }

        if (addOrder == null) {
            return "redirect:/home/products/buy/" + id;
        }

        String personName = addOrder.getPersonName();
        String phoneNumber = addOrder.getPhoneNumber();
        String address = addOrder.getAddress();
        String deliveryType = addOrder.getDeliveryType();

        if ((personName == null || personName.trim().isEmpty()) ||
                (phoneNumber == null || phoneNumber.trim().isEmpty()) ||
                (address == null || address.trim().isEmpty()) ||
                (deliveryType == null || deliveryType.trim().isEmpty())) {
            return "redirect:/home/products/buy/" + id;
        }

        ShowKnife showKnife = this.knifeService.findKnifeById(id);
        if (showKnife != null) {
            addOrder.setKnife(showKnife);
            ShowUser loginModel = (ShowUser) session.getAttribute("loginModel");
            addOrder.setCustomer(loginModel);
            this.orderService.addOrder(addOrder);
        }

        return "redirect:/home/index";
    }
}
