package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface DogService {
    Optional<Dog> findDogById(long id);
    List<Dog> findAllDogs();
    Dog saveDog(@NotNull Dog dog);
    void deleteDogById(long id);
    int updateDog(long id, @NotNull Dog dog);
}
