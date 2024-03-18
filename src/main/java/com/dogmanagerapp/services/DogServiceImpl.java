package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.repositories.DogRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class DogServiceImpl implements DogService {

    private final DogRepository dogRepository;

    public DogServiceImpl(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    @Override
    public Optional<Dog> findDogById(long id) {
        return this.dogRepository.findById(id);
    }

    @Override
    public List<Dog> findAllDogs() {
        return this.dogRepository.findAll();
    }

    @Override
    public Dog saveDog(Dog dog) {
        return this.dogRepository.save(dog);
    }

    @Override
    public void deleteDogById(long id) {
        this.dogRepository.deleteById(id);
    }

    @Override
    public int updateDog(long id, Dog dog) {
        return this.dogRepository.update(id, dog);
    }
}
