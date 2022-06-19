package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;


public interface UserServices {
    public List<User> getAllUsers();

    public User getUser(Long id);

    public User addUser(User user);

    public User updateUser(User user, Long id);

    public void deleteUser(Long id);
}
