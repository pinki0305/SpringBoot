package com.example.demo.dto;

import java.util.List;

public class CoivdServiceList
{
    List<CovidServiceResponse> response;

public List<CovidServiceResponse> getResponse() {
        return response;
        }

public void setResponse(List<CovidServiceResponse> response) {
        this.response = response;
        }
        }