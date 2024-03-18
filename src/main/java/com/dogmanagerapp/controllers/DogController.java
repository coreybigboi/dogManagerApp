package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.services.DogService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/dogs")
public class DogController {

    private final DogService dogService;

    DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Dog> index() {
        return dogService.getAllDogs();
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Dog getDog(int id){
        return new Dog("dobby", "greyhound", 6);
    }
}
