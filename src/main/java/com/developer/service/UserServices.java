package com.developer.service;

import com.developer.entity.User;

import java.util.List;


public interface UserServices {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public User addUser(User user);

    public User updateUser(User user, Long id);

    public void deleteUser(Long id);

    public List<User> getUserByEmail(String email);

}
