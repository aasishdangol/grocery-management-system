package com.developer.service;

import com.developer.entity.Role;

import java.util.List;


public interface RoleServices {
    public List<Role> getAllRoles();

    public Role addRole(Role role);

    public Role getRole(Long id);

    public Role updateRole(Role role, Long id);

    public void deleteRole(Long id);
}
