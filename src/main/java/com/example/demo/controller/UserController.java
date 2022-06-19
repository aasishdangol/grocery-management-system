package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.CategoryServices;
import com.example.demo.service.UserServices;
import com.example.demo.service.UserTypeServices;
import com.example.demo.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserTypeServices userTypeServices;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
     ObjectMapper objectMapper;

    @GetMapping("/create")
    public String userAddForm(Model model)  {
        User user = new User();
        model.addAttribute("userTitle", "User Create");
        model.addAttribute("user", user);
        model.addAttribute("user_type", userTypeServices.getAllUserType());
        return "user/useraddupdate";
    }

    @GetMapping("/list")
    public String userlist(Model model) throws JsonProcessingException {
        model.addAttribute("userList", userServices.getAllUsers());
        return "user/userlist";
    }

    @PostMapping("/createorupdate")
    public String createUser(Model model, User user){
        if (user.getId() != null){
            userServices.updateUser(user, user.getId());
        }else {
            user.setUserId(ConstantValue.generateUserId());
            user.setStatus("Active");
            userServices.addUser(user);
        }
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model){
        User user = new User();
        user = userServices.getUser(id);
        model.addAttribute("user", user);
        model.addAttribute("user_type", userTypeServices.getAllUserType());
        model.addAttribute("userTitle", "User Update");
        return "user/useraddupdate";
    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        userServices.deleteUser(id);
        return "redirect:/user/list";
    }

}
