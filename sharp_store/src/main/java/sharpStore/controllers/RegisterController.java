package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.ModelAttribute;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.model.Model;
import sharpStore.enums.Role;
import sharpStore.models.bindingModels.AddUser;
import sharpStore.services.api.UserService;
import sharpStore.utils.LoggedInUtil;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Stateless
@Controller
public class RegisterController {

    @Inject
    private UserService userService;

    @Inject
    private HttpSession session;

    @GetMapping("/home/register")
    public String getRegisterPage(Model model) {
        if (LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/";
        }

        model.addAttribute("title", "Register");
        model.addAttribute("view", "register.jsp");
        return "base-layout";
    }

    @PostMapping("/home/register")
    public String register(@ModelAttribute AddUser addUser) {
        if (LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/";
        }

        if (addUser == null) {
            return "redirect:/home/register";
        }

        String username = addUser.getUsername();
        String password = addUser.getPassword();

        if ((username == null || username.trim().isEmpty()) ||
                (password == null || password.trim().isEmpty())) {
            return "redirect:/home/register";
        }

        addUser.setRole(Role.USER);
        boolean isUserAdded = this.userService.addUser(addUser);
        if (!isUserAdded) {
            return "redirect:/home/register";
        }

        return "redirect:/home/login";
    }
}
