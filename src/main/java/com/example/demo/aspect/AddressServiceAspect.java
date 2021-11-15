package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AddressServiceAspect
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //for a single a class
     @Before("execution(* com.example.demo.Controller.First.*(..))")
    // for a package
   // @Before("execution(* com.example.demo.Service.*.*(..))")
    public void before(JoinPoint joinPoint){
        //Advice
        System.out.println("hi");
        logger.info(" Check for user access ");
        logger.info(" Allowed execution for {}", joinPoint);
    }
    @After("execution(* com.example.demo.Service.*.*(..))")
    public void after(JoinPoint joinPoint){
        //Advice
        System.out.println("byw");

    }

    @Around("execution(* com.example.demo.Controller.First.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
         System.out.println("...........................");
        long startTime = System.currentTimeMillis();

        Object response =  joinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return response;
    }
    @Around("execution(* com.example.demo.Service.UserServiceImpl.getAllLearner())")
    public Object employeeAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
        System.out.println("Before invoking getEid() method");
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("After invoking getEid() method. Return value="+value);
        return value;
    }

}
