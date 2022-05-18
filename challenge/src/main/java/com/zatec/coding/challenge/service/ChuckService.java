package com.zatec.coding.challenge.service;

import com.zatec.coding.challenge.model.ChuckResult;
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
public class ChuckService {

    @Autowired
    private RestTemplate restTemplate;
    private String baseUrl = "https://api.chucknorris.io/jokes/";

    public List<String> getCategories() {
        try {
            final RequestEntity requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(baseUrl + "categories"));
            final ResponseEntity<List<String>> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<List<String>>() {});
            return responseEntity.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public ChuckResult getChuckResult(String category) {
        try {
            final RequestEntity requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(baseUrl + "random?category=" + category));
            final ResponseEntity<ChuckResult> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ChuckResult>() {});
            return responseEntity.getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
