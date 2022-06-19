package com.developer.controller;

import com.developer.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/identity")
public class IdentityController {



    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {
        return "/dashboard";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("Userpage", new User());
        return "/identity/login";
    }

    @GetMapping(value = "/profile")
    public String profilePage(Model model) {
        model.addAttribute("Userpage", new User());
        return "/identity/profile";
    }
    @GetMapping(value = "/index")
    public String indexPage(Model model) {
        return "/index";
    }
}
