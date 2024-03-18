package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.services.DogService;
import com.dogmanagerapp.services.DogServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/dogs")
public class DogController {

    private final DogServiceImpl dogService;

    DogController(DogServiceImpl dogService) {
        this.dogService = dogService;
        this.dogService.saveDog("dobby", "greyhound", 6);
        this.dogService.saveDog("bella", "border collie", 6);
        this.dogService.saveDog("luna", "border collie", 6);
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Dog> index() {
        return dogService.findAllDogs();
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Optional<Dog> getDog(Long id){
        return this.dogService.findDogById(id);
    }

    @Post
    HttpResponse<Dog> save(@Body @Valid SaveDogCommand cmd) {
        Dog dog = this.dogService.saveDog(cmd.getName(), cmd.getBreed(), cmd.getAge());
        return HttpResponse.created(dog);
    }
}
