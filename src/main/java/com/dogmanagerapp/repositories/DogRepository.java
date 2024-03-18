package com.dogmanagerapp.repositories;

import com.dogmanagerapp.models.Dog;
import jakarta.validation.constraints.NotBlank;

import java.util.List;
import java.util.Optional;

public interface DogRepository {
    Optional<Dog> findById(long id);

    Dog save(@NotBlank String name, String breed, int age);

    Dog saveWithException(@NotBlank String name, String breed, int age);

    void deleteById(long id);

    List<Dog> findAll();

    int update(long id, String name, String breed, int age);
}
