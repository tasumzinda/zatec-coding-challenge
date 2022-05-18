package com.zatec.coding.challenge.controller;

import com.zatec.coding.challenge.api.SearchApi;
import com.zatec.coding.challenge.model.SearchResult;
import com.zatec.coding.challenge.service.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SearchController implements SearchApi {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public ResponseEntity<SearchResult> searchGet(String query) {
        return ResponseEntity.ok().body(searchService.getResult(query));
    }
}
