package com.example.demo.repository;

import com.example.demo.entitites.Learner;
import com.example.demo.entitites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer>
{
    Learner findByEid(String eid);

}
