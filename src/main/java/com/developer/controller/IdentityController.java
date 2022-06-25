package com.developer.controller;

import com.developer.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @GetMapping(value = "/404page")
    public String accessDeniedPage(){
        return "/404page";
    }

    @GetMapping(value = "/login")
    public String loginPage(Model model) {
        model.addAttribute("loginUser", new User());
        return "/identity/login";
    }

    @GetMapping(value = "/profile")
   @PreAuthorize("hasAuthority('PROFILE_VIEW')")
    public String profilePage(Model model) {
        model.addAttribute("Userpage", new User());
        return "/identity/profile";
    }
    @GetMapping(value = "/index")
    public String indexPage(Model model) {
        return "/index";
    }

//    @GetMapping(value = "/bill")
//    @PreAuthorize("hasAuthority('BILL_VIEW')")
//    public String billPage(Model model) {
//        model.addAttribute("Userpage", new User());
//        return "/sales_details";
//    }
}
