package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.parameters.PathVariable;
import mvcFramework.annotations.parameters.RequestParam;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.model.Model;
import sharpStore.models.viewModels.ShowKnife;
import sharpStore.services.api.KnifeService;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@Stateless
public class HomeController {

    @Inject
    private KnifeService knifeService;

    @GetMapping("/")
    public String home() {
        return "redirect:/home/index";
    }

    @GetMapping("/home/index")
    public String index(Model model) {
        model.addAttribute("title", "Index");
        model.addAttribute("view", "home.jsp");
        return "base-layout";
    }

    @GetMapping("/home/index/{navColor}")
    public String changeNavColor(@PathVariable("navColor") String navColor,
                                 HttpServletResponse response) {
        if (navColor != null) {
            Cookie navColorCookie = new Cookie("navColor", navColor);
            navColorCookie.setPath("/");
            response.addCookie(navColorCookie);
        }

        return "redirect:/";
    }
}
