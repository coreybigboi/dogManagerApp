package com.dogmanagerapp.repositories;

import com.dogmanagerapp.models.Dog;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface DogRepository {
    Optional<Dog> findById(long id);

    Dog save(@NotNull Dog dog);

    void deleteById(long id);

    List<Dog> findAll();

    int update(long id, Dog dog);
}
