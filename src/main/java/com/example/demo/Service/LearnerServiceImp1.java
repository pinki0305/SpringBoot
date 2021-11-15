package com.example.demo.Service;

import com.example.demo.entitites.Learner;
import com.example.demo.dto.LearnerRequest;
import com.example.demo.entitites.TimeOutException;
import com.example.demo.entitites.TimeOutExceptionNewUser;
import com.example.demo.entitites.User;
import com.example.demo.repository.LearnerRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDateTime;
import java.util.*;

import java.util.List;

@Service
public class LearnerServiceImp1 implements LearnerService{
    @Autowired
    LearnerRepository learnerRepository;


    @Override
    public boolean authenticate(String eid)
    {
        Learner learner=learnerRepository.findByEid(eid);
        if(learner==null)
            return false;
        else
            return true;
    }

    @Override
    public List<User> getAllLearner() {
        List<Learner> list = learnerRepository.findAll();
        return null;
    }

//    @Override
//    public List<Learner> getAllLearner() {

//        return list;
//    }

    @Override
    public Learner saveLearner(LearnerRequest learnerRequest)
    {
              Learner l=new Learner();
              l.setEid(learnerRequest.getEid());

                LocalDateTime d = LocalDateTime.now();
                l.setTime_in(d.toString());
                // if(learnerRepository.findByEid(learnerRequest.getEid())==null) {
                Learner learner11 = learnerRepository.save(l);
                   return learner11;
              // }
              // else  {
//return null;
                    // }
    }
   /** @Override
    public Learner saveLearner(LearnerRequest learnerRequest)
    {
        Learner l=new Learner();
        l.setEid(learnerRequest.getEid());

        Date d = new Date();
        l.setTime_in(d.toString());
        Learner learner11 = learnerRepository.save(l);
        return learner11;

    }*/

    @Override
    public Learner updateLearner(LearnerRequest learnerRequest) {

        Learner response=learnerRepository.findByEid(learnerRequest.getEid());
        if(response.getTime_out() ==null && response.getTime_in() !=null) {
            LocalDateTime d = LocalDateTime.now();
            response.setTime_out(d.toString());
            Learner u = learnerRepository.save(response);
            return u;
        }
        else if(response.getTime_out() !=null && response.getTime_in() !=null)
        {
            throw new TimeOutException();
        }
        else if(response.getEid()==null)
        {
            throw  new TimeOutExceptionNewUser();
        }
        else
        {
            throw  new TimeOutExceptionNewUser();
        }


      /**  Learner l=new Learner();
        l.setEid(learnerRequest.getEid());

        Date d = new Date();
        l.setTime_out(d.toString());
        // if(learnerRepository.findByEid(learnerRequest.getEid())==null) {
        Learner learner11 = learnerRepository.save(l);
        return learner11;*/
    }

}
