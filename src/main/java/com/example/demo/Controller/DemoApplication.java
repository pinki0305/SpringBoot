package com.example.demo.Controller;

import com.example.demo.Service.*;
import com.example.demo.dto.*;
import com.example.demo.entitites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

@RestController
public class DemoApplication
{
    @Autowired
    LearnerService learnerService;
    @Autowired
    UserService userService;
    @Autowired
    AddressService addressService;
    @Autowired
    CovidService covidService;
    @Autowired
    TestService testService;

    @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CovidServiceResponse> greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return covidService.getCovidData();
    }
    @GetMapping(value="/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public TestServiceResponse test(@RequestParam(name="name", required=false, defaultValue="World") String name) {
      TestServiceResponse testServiceResponse=testService.getData();
        return testServiceResponse;
    }
    @GetMapping("/hello")
    public String getHello() {
        return "hello";
    }

    @PostMapping("/authenticate")
    public boolean authenticateUser(@RequestBody LearnerRequest learnerRequest){
        Boolean isAuthenticated = learnerService.authenticate(learnerRequest.getEid());
        return isAuthenticated;
    }
    @PostMapping("/authenticate1")
    public boolean authenticateUser1(@RequestBody UserRequest userRequest){
        Boolean isAuthenticated = userService.authenticate1(userRequest.getUsername(),userRequest.getPassword());
       return isAuthenticated;
    }
    @GetMapping("/getuserdetails")
    public List<User> getLearnerDetails()
    {
        List<User> list = userService.getAllLearner();
        return list;
    }
    @PostMapping("/savein")
    public Learner saveLearner(@RequestBody LearnerRequest learnerRequest)
    {
        if(learnerService.authenticate(learnerRequest.getEid())==true)
        {
            Learner learner1 = learnerService.saveLearner(learnerRequest);
            return learner1;
        }
        else
        {
            throw new TimeInException();
        }
    }
    @PostMapping("/saveuser")

    public User saveUser(@RequestBody UserRequest userRequest)
    {

            User user1 = userService.saveUser(userRequest);
            return user1;

    }
    @PostMapping("/saveaddress")

    public Address saveAddress(@RequestBody AddressRequest addressRequest)
    {

        Address address = addressService.saveAddress(addressRequest);
        return address;

    }
    @PostMapping("/updateaddress")

    public String updateAddress(@RequestBody AddressRequest addressRequest)
    {

        return addressService.updateAddress(addressRequest.getId(),addressRequest.getStreet1(),addressRequest.getStreet2(),addressRequest.getCity());


    }
    @PutMapping("/updateuser")
    @ResponseBody
    public String updateUser(@RequestBody UpdateRequest updateRequest)
    {
        return userService.updateUser(updateRequest.getId(),updateRequest.getPassword());
    }

    @PutMapping("/deleteuser")
    public String deleteUser(@RequestBody DeleteRequest deleteRequest)
    {


        return userService.deleteUser(deleteRequest.getId());

    }
    @GetMapping("/deleteuser1/{id}")
    public String deleteUser1(@PathVariable("id") int id)
    {


        return userService.deleteUser(id);

    }
    @PutMapping("/update")
    public Learner updateLearner(@RequestBody LearnerRequest learnerRequest)
    {
        if(learnerService.authenticate(learnerRequest.getEid())==false)
        {
            Learner learner1 = learnerService.updateLearner(learnerRequest);
            return learner1;
        }
        else
        {
            throw new TimeOutExceptionNewUser();
        }
    }

}
