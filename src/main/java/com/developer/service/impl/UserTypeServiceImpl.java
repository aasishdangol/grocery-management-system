package com.developer.service.impl;


import com.developer.entity.UserType;
import com.developer.repository.UserTypeRepository;
import com.developer.service.UserTypeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeServiceImpl implements UserTypeServices {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Override
    public List<UserType> getAllUserType() {
        return userTypeRepository.findAll();
    }

    @Override
    public UserType getUserType(Long id) {
        return userTypeRepository.findById(id).get();
    }

    @Override
    public UserType addUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    @Override
    public UserType updateUserType(UserType userType, Long id) {
        UserType tempUserType = userTypeRepository.findById(id).get();
        if (null != tempUserType) {
            userType.setId(id);
            return userTypeRepository.save(userType);
        }
        return null;
    }

    @Override
    public void deleteUserType(Long id) { userTypeRepository.deleteById(id);

    }
}
