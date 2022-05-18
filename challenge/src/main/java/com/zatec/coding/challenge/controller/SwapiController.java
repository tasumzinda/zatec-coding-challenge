package com.zatec.coding.challenge.controller;

import com.zatec.coding.challenge.api.SwapiApi;
import com.zatec.coding.challenge.model.People;
import com.zatec.coding.challenge.service.SwapiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SwapiController implements SwapiApi {

    private SwapiService swapiService;

    public SwapiController(SwapiService swapiService) {
        this.swapiService = swapiService;
    }

    @Override
    public ResponseEntity<People> swapiPeopleGet() {
        return ResponseEntity.ok().body(swapiService.getPeople());
    }
}
