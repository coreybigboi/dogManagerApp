package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface DogService {
    Optional<Dog> findDogById(long id);

    Dog saveDog(@NotBlank String name, String breed, int age);

    void deleteDogById(long id);

    List<Dog> findAllDogs();

    int updateDog(long id, String name, String breed, int age);
}
