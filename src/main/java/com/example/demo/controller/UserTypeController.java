package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.entity.UserType;
import com.example.demo.service.UserTypeServices;
import com.example.demo.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usertype")
public class UserTypeController {
    @Autowired
    private UserTypeServices userTypeServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(UserTypeController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    public String userTypeAddForm(Model model)  {
        UserType userType = new UserType();
        model.addAttribute("userTypeTitle", "User Create");
        model.addAttribute("userType", userType);
        return "usertype/user_addupdateform";
    }

    @GetMapping("/list")
    public String usertypelist(Model model) throws JsonProcessingException {
        model.addAttribute("userTypeList", userTypeServices.getAllUserType());
        return "usertype/user_list";
    }

    @PostMapping("/createorupdate")
    public String createUserType(Model model, UserType userType){
        if (userType.getId() != null){
            userTypeServices.updateUserType(userType, userType.getId());
        }else {
            userType.setUsertypeId(ConstantValue.generateUserTypeId());
            userTypeServices.addUserType(userType);
        }
        return "redirect:/usertype/list";
    }

    @GetMapping("/update/{id}")
    public String updateUserTypeForm(@PathVariable Long id, Model model){
        UserType userType = new UserType();
        userType = userTypeServices.getUserType(id);
        model.addAttribute("userType", userType);

        model.addAttribute("userTypeTitle", "User Update");
        return "usertype/user_addupdateform";
    }

    @GetMapping("/delete/{id}")
    public String deleteUserType(@PathVariable Long id){
        userTypeServices.deleteUserType(id);
        return "redirect:/usertype/list";
    }
}