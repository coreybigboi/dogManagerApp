package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.services.DogServiceImpl;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
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
        this.createMockDogs();
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
    HttpResponse<Dog> save(@Body @Valid DogSaveCommand cmd) {
        Dog dog = new Dog(cmd.getName(), cmd.getBreed(), cmd.getAge());
        this.dogService.saveDog(dog);
        return HttpResponse.created(dog);
    }

    @Put
    HttpResponse<?> update(@Body @Valid DogUpdateCommand cmd){
        Dog dog = new Dog(cmd.getName(), cmd.getBreed(), cmd.getAge());
        int result = this.dogService.updateDog(cmd.getId(), dog);

        return HttpResponse.noContent();
    }

    @Delete("/{id}")
    HttpResponse<?> delete(Long id) {
        this.dogService.deleteDogById(id);
        return HttpResponse.noContent();
    }

    private void createMockDogs() {
        Dog dog1 = new Dog("Dobby", "Greyhound", 6);
        Dog dog2 = new Dog("Luna", "Border Collie", 1);
        Dog dog3 = new Dog("Bella", "Border Collie", 11);
        this.dogService.saveDog(dog1);
        this.dogService.saveDog(dog2);
        this.dogService.saveDog(dog3);
    }
}
