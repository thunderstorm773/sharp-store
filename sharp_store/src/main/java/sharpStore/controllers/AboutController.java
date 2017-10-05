package sharpStore.controllers;

import mvcFramework.annotations.controller.Controller;
import mvcFramework.annotations.request.GetMapping;
import mvcFramework.model.Model;
import javax.ejb.Stateless;

@Stateless
@Controller
public class AboutController {

    @GetMapping("/home/about")
    public String getAboutPage(Model model) {
        model.addAttribute("title", "About Us");
        model.addAttribute("view", "about.jsp");
        return "base-layout";
    }
}
