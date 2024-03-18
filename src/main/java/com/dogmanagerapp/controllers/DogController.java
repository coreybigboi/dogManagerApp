package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.services.DogService;
import com.dogmanagerapp.services.DogServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/dogs")
public class DogController {

    private final DogServiceImpl dogService;

    DogController(DogServiceImpl dogService) {
        this.dogService = dogService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Dog> index() {
        return dogService.findAllDogs();
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Optional<Dog> getDog(Long id){
        return this.dogService.findDogById(id);
    }
}
