package com.zatec.coding.challenge.service;

import com.zatec.coding.challenge.model.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class SwapiService {

    @Autowired
    private RestTemplate restTemplate;
    private String baseUrl = "https://swapi.dev/api/people/";

    public People getPeople() {
        try {
            final RequestEntity requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(baseUrl));
            final ResponseEntity<People> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<People>() {});
            return responseEntity.getBody();
        } catch (Exception e) {
            return null;
        }
    }
}
