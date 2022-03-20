package com.example.Medical.Records.service;

import com.example.Medical.Records.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;


public interface UserService extends UserDetailsService {
    User findUserByUserName(String name);

    User findUserByEmail(String name);


//    UserServiceModel editUserProfile(UserServiceModel userServiceModel, String oldPassword);

    List<User> findAllUsers();


    User findUserById(Long id);

    void deleteUser(User user);
}
