package com.example.demo.Service;

import com.example.demo.dto.CovidServiceResponse;

import java.util.List;

public interface CovidService
{
    List<CovidServiceResponse> getCovidData();

}

