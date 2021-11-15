package com.example.demo.dto;

import java.util.List;

public class TestServiceResponse
{
    private String name;
    private List<Country> country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }
}

