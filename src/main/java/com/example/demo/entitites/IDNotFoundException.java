package com.example.demo.entitites;

public class IDNotFoundException  extends RuntimeException{
    public IDNotFoundException(int id)
    {
        super("user id not found "+id);
    }
}
