package com.example.demo.service;





import com.example.demo.entity.UserType;

import javax.management.relation.Role;
import java.util.List;

public interface UserTypeServices  {
    public List<UserType> getAllUserType();

    public UserType getUserType(Long id);

    public UserType addUserType(UserType userType);

    public UserType updateUserType(UserType userType, Long id);

    public void deleteUserType(Long id);
}
