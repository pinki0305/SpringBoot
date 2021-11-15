package com.example.demo.Service;

import com.example.demo.entitites.Learner;
import com.example.demo.dto.LearnerRequest;
import com.example.demo.entitites.User;

import java.util.List;

public interface LearnerService
{
    boolean authenticate(String eid);
    List<User> getAllLearner();
    Learner saveLearner(LearnerRequest user);
    Learner updateLearner(LearnerRequest user);

}