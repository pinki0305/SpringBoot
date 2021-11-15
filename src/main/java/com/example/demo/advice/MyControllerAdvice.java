package com.example.demo.advice;

import com.example.demo.entitites.IDNotFoundException;
import com.example.demo.entitites.TimeInException;
import com.example.demo.entitites.TimeOutException;
import com.example.demo.entitites.TimeOutExceptionNewUser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = TimeInException.class)
    public ResponseEntity<Object> exception(TimeInException exception, WebRequest request)
    {
        ResponseEntityTimeIn response= new ResponseEntityTimeIn("404","Conflict","Learner already timed-in",new Date().toString());
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(value = TimeOutException.class)
    public ResponseEntity<Object> exception(TimeOutException exception, WebRequest request)
    {
        ResponseEntityTimeOut response= new ResponseEntityTimeOut("409","Conflict","Learner already timed-out",new Date().toString());
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    @ExceptionHandler(value = TimeOutExceptionNewUser.class)
    public ResponseEntity<Object> exception(TimeOutExceptionNewUser exception, WebRequest request)
    {
        ResponseEntityTimeOut response= new ResponseEntityTimeOut("404","Conflict","Learner has not  timed-in",new Date().toString());
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
    @ExceptionHandler(value = IDNotFoundException.class)
    public ResponseEntity<Object> exception(IDNotFoundException exception, WebRequest request)
    {
        ResponseEntityIDNotFound response= new ResponseEntityIDNotFound("404","Conflict","ID Not Found "+exception.getMessage(),new Date().toString());
        return handleExceptionInternal(exception, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
