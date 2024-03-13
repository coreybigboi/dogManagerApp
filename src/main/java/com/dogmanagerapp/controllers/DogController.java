package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.services.DogService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/dogs")
public class DogController {

    private final DogService dogService;

    DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() { return "dogs works."; }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Dog getDog(int id){
        return dogService.getDobby();
    }
}
