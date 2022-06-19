package com.developer.service.impl;

import com.developer.entity.User;
import com.developer.repository.UserRepository;
import com.developer.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User addUser(User users) {
        return userRepository.save(users);
    }

    @Override
    public User updateUser(User users, Long id) {
        User tempUser = userRepository.findById(id).get();
        if (null != tempUser) {
            users.setId(id);
            return userRepository.save(users);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
    userRepository.deleteById(id);
        }

    }

