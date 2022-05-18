package com.zatec.coding.challenge.controller;

import com.zatec.coding.challenge.api.ChuckApi;
import com.zatec.coding.challenge.model.ChuckResult;
import com.zatec.coding.challenge.service.ChuckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class ChuckController implements ChuckApi {

    private ChuckService chuckService;

    public ChuckController(ChuckService chuckService) {
        this.chuckService = chuckService;
    }

    @Override
    public ResponseEntity<List<String>> chuckCategoriesGet() {
        return ResponseEntity.ok().body(chuckService.getCategories());
    }

    @Override
    public ResponseEntity<ChuckResult> chuckCategoryGet(String category) {
        return ResponseEntity.ok().body(chuckService.getChuckResult(category));
    }
}
