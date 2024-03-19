package com.dogmanagerapp.application;

import com.dogmanagerapp.models.Dog;

public class DogDtoMapper {
    public static DogDto toDto(Dog dog) {
        return new DogDto(dog.getId(), dog.getName(), dog.getBreed(), dog.getAge());
    }

    public static Dog toDog(DogDto dto) {
        return new Dog(dto.id(), dto.name(), dto.breed(), dto.age());
    }
}
