package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.repositories.DogRepositoryImpl;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class DogService {

    private final DogRepositoryImpl dogRepository;

    public DogService(DogRepositoryImpl dogRepository) {
        this.dogRepository = dogRepository;
    }

    private Dog[] getMockDogs() {
        final int numDogs = 5;
        Dog[] dogs = new Dog[numDogs];
        for(int i = 0; i < numDogs; i++) {
            String name = "Dog " + i;
            String breed = "Breed " + i;
            int age = 1 + i;
            Dog dog = new Dog(name, breed, age);
            dogs[i] = dog;
        }
        return dogs;
    }

    public List<Dog> getAllDogs() {
        return this.dogRepository.findAll();
    }
}
