package com.developer.controller;

import com.developer.entity.Role;
import com.developer.service.RoleServices;
import com.developer.util.ConstantValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleServices roleServices;
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    ObjectMapper objectMapper;

    @GetMapping("/create")
    @PreAuthorize("hasAuthority('GET_ROLE')")
    public String RoleAddForm(Model model) {
        Role role = new Role();
        model.addAttribute("userRoleTitle", "Role Add");
        model.addAttribute("role", role);
        return "role/role_addupdateform";
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('LIST_ROLE')")
    public String Rolelist(Model model) throws JsonProcessingException {
        model.addAttribute("roleList", roleServices.getAllRoles());
        return "role/role_list";
    }

    @PostMapping("/createorupdate")
    @PreAuthorize("hasAuthority('CREATE_ROLE')")
    public String createRole(Model model, Role role) {
        if (role.getId() != null) {
            roleServices.updateRole(role, role.getId());

        } else {
            roleServices.addRole(role);
        }

        return "redirect:/role/list";
    }


    @GetMapping("/update/{id}")
    @PreAuthorize("hasAuthority('UPDATE_ROLE')")
    public String updateRoleForm(@PathVariable Long id, Model model) {
        Role role = new Role();
        role = roleServices.getRole(id);
        model.addAttribute("role", role);
        model.addAttribute("userRoleTitle", "Role Update");
        return "role/role_addupdateform";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('DELETE_ROLE')")
    public String deleteRole(@PathVariable Long id) {
        roleServices.deleteRole(id);
        return "redirect:/role/list";
    }

}
