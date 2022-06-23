package com.developer.controller;

import com.developer.entity.Role;
import com.developer.entity.User;
import com.developer.service.RoleServices;
import com.developer.service.UserServices;
import com.developer.service.UserTypeServices;
import com.developer.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @Autowired
    private UserTypeServices userTypeServices;

    @Autowired
    private RoleServices roleServices;
    List<Role> roleList;
    private User user;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
     ObjectMapper objectMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/create")
    public String userAddForm(Model model)  {
        User user = new User();
        roleList = roleServices.getAllRoles();
        user.setRoleList(roleList);
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
        roleList = new ArrayList<>();
        user.getRoleList().forEach(role -> {
            if (role.getSelected()){
                this.roleList.add(role);
            }
        });
        user.setUserRoles(new HashSet<>(roleList));
        if (user.getId() != null){
            User dbUser = userServices.getUser(user.getId());
            user.setUserCode(dbUser.getUserCode());
            user.setStatus(dbUser.getStatus());
            userServices.updateUser(user, user.getId());
        }else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUserCode(ConstantValue.generateUserId());
            user.setStatus("Active");
            userServices.addUser(user);
        }
        return "redirect:/user/list";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable Long id, Model model){
        roleList = roleServices.getAllRoles();
        user = userServices.getUser(id);
        user.setRoleList(roleList);

        user.getUserRoles().forEach(userRole ->{
            user.getRoleList().forEach(role -> {
                if (userRole.getId().equals(role.getId())){
                    role.setSelected(true);
                }
            });
        });


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
