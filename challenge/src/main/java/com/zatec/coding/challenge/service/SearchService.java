package com.zatec.coding.challenge.service;

import com.zatec.coding.challenge.model.ChuckSearchResultResponse;
import com.zatec.coding.challenge.model.People;
import com.zatec.coding.challenge.model.SearchResult;
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
public class SearchService {

    @Autowired
    private RestTemplate restTemplate;
    private static final String swapiUrl = "https://swapi.dev/api/people/";
    private static final String chuckUrl = "https://api.chucknorris.io/jokes/search";

    private ChuckSearchResultResponse searchChuck(String query) {
        try {
            final RequestEntity requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(chuckUrl + "?query=" + query));
            final ResponseEntity<ChuckSearchResultResponse> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<ChuckSearchResultResponse>() {});
            return responseEntity.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    private People getPeople(String search) {
        try {
            final RequestEntity requestEntity = new RequestEntity<>(HttpMethod.GET, new URI(swapiUrl + "?search=" + search));
            final ResponseEntity<People> responseEntity = restTemplate.exchange(requestEntity, new ParameterizedTypeReference<People>() {});
            return responseEntity.getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public SearchResult getResult(String term) {
        SearchResult result = new SearchResult();
        ChuckSearchResultResponse  chuckSearchResultResponse = searchChuck(term);
        result.setChuckResult(chuckSearchResultResponse);
        People people = getPeople(term);
        result.setSwapiResult(people);
        result.setSwapiEndPoint(swapiUrl);
        result.setChuckEndPoint(chuckUrl);
        return result;
    }

}
