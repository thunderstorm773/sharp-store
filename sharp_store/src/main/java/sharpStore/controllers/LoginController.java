package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.RequestParam;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.annotations.request.PostMapping;
import mvcFramework.model.Model;
import sharpStore.models.viewModels.ShowUser;
import sharpStore.services.api.UserService;
import sharpStore.utils.LoggedInUtil;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Stateless
@Controller
public class LoginController {

    @Inject
    private UserService userService;

    @Inject
    private HttpSession session;

    @GetMapping("/home/login")
    public String getLoginPage(Model model) {
        if (LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/";
        }

        model.addAttribute("title", "Login");
        model.addAttribute("view", "login.jsp");
        return "base-layout";
    }

    @PostMapping("/home/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpSession session) {
        if (LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/";
        }

        if ((username == null || username.trim().isEmpty()) ||
                (password == null || password.trim().isEmpty())) {
            return "redirect:/home/login";
        }

        ShowUser showUser = this.userService
                .findUserByUsernameAndPassword(username, password);
        if (showUser == null) {
            return "redirect:/home/login";
        }

        ShowUser loginModel = new ShowUser(
                showUser.getUsername(), showUser.getRole());
        session.setAttribute("loginModel", loginModel);
        return "redirect:/";
    }

    @GetMapping("/home/logout")
    public String logout(HttpSession session) {
        if (!LoggedInUtil.isUserLoggedIn(this.session)) {
            return "redirect:/";
        }

        ShowUser loginModel = (ShowUser) session.getAttribute("loginModel");
        if (loginModel != null) {
            session.invalidate();
        }

        return "redirect:/";
    }
}
