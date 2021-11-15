package com.example.demo.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.entitites.User;

import java.util.List;

public interface UserService
{
    boolean authenticate1(String username,String password);
    User saveUser(UserRequest userRequest);
    String updateUser(int id,String password);
    String deleteUser(int id);
    List<User> getAllLearner();

}
