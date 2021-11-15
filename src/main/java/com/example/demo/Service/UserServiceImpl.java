package com.example.demo.Service;

import com.example.demo.dto.UserRequest;

import com.example.demo.entitites.IDNotFoundException;
import com.example.demo.entitites.Learner;
import com.example.demo.entitites.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements  UserService
{
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean authenticate1(String userName, String password) {
        User user=userRepository.findByUsernameAndPassword(userName,password);
        if(user==null)
            return false;
        else
            return true;

    }

    @Override
    public User saveUser(UserRequest userRequest) {

        User u= new User();
        u.setUsername(userRequest.getUsername());
        u.setPassword(userRequest.getPassword());
        u.setAddress(userRequest.getAddress());
        User user=userRepository.save(u);
        return user;
    }

    @Override
    public String updateUser(int id,String password) {

        User response=userRepository.findById(id);
        if(response !=null)
        {
            response.setId(id);

            response.setPassword(password);
            userRepository.save(response);
            return "Update Record";
        }
        else
        {
            throw new IDNotFoundException(id);

        }

    }

    @Override
    public String deleteUser(int id) {
        User response = userRepository.findById(id);
        if (response != null) {
            userRepository.delete(response);
            return "deleted";
        } else
        {
            throw new IDNotFoundException(id);
        }

    }

    @Override
    public List<User> getAllLearner() {
        List<User> list = userRepository.findAll();
        return list;
    }
}
