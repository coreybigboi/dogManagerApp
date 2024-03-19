package com.dogmanagerapp.services;

import com.dogmanagerapp.application.DogDtoMapper;
import com.dogmanagerapp.models.Dog;
import com.dogmanagerapp.application.DogDto;
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
    public Optional<DogDto> findDogById(long id) {
        Optional<Dog> dog = this.dogRepository.findById(id);
        return dog.map(DogDtoMapper::toDto);
    }

    @Override
    public List<DogDto> findAllDogs() {
        List<Dog> dogs = this.dogRepository.findAll();
        return DogDtoMapper.toDtoList(dogs);
    }

    @Override
    public DogDto saveDog(Dog dog) {
        Dog result = this.dogRepository.save(dog);
        return DogDtoMapper.toDto(result);
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
