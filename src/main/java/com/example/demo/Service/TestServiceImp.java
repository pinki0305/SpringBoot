package com.example.demo.Service;

import com.example.demo.dto.CovidServiceResponse;
import com.example.demo.dto.TestServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class TestServiceImp implements TestService
{


    @Autowired
    RestTemplate restTemplate;

    @Override
    public TestServiceResponse getData() {


        HttpHeaders httpHeaders = setHeaders();

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        ResponseEntity<TestServiceResponse> response = null;
        try {

            response = restTemplate.exchange("https://api.nationalize.io/?name=nathaniel",
                    HttpMethod.GET, entity, TestServiceResponse.class);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }

      System.out.println(response.getBody()+">>>>>>>>>>>>>>>>>>>>>>>>");
        return response.getBody();
    }

    private HttpHeaders setHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("useQueryString", String.valueOf(true));

        return  headers;
    }
}
