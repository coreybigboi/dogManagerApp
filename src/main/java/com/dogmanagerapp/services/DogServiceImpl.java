package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.repositories.DogRepositoryImpl;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class DogServiceImpl implements DogService {

    private final DogRepositoryImpl dogRepository;

    public DogServiceImpl(DogRepositoryImpl dogRepository) {
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

    @Override
    public Optional<Dog> findDogById(long id) {
        return this.dogRepository.findById(id);
    }

    @Override
    public Dog saveDog(String name, String breed, int age) {
        return this.dogRepository.save(name, breed, age);
    }

    @Override
    public void deleteDogById(long id) {
        this.dogRepository.deleteById(id);
    }

    @Override
    public List<Dog> findAllDogs() {
        return this.dogRepository.findAll();
    }

    @Override
    public int updateDog(long id, String name, String breed, int age) {
        return this.dogRepository.update(id, name, breed, age);
    }
}
