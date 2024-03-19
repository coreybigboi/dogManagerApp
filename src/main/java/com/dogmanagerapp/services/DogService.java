package com.dogmanagerapp.services;

import com.dogmanagerapp.application.DogDto;
import com.dogmanagerapp.models.Dog;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface DogService {
    Optional<DogDto> findDogById(long id);
    List<DogDto> findAllDogs();
    DogDto saveDog(@NotNull Dog dog);
    void deleteDogById(long id);
    int updateDog(long id, @NotNull Dog dog);
}
