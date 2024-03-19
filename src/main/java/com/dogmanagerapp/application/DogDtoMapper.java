package com.dogmanagerapp.application;

import com.dogmanagerapp.models.Dog;

import java.util.ArrayList;
import java.util.List;

public class DogDtoMapper {
    public static DogDto toDto(Dog dog) {
        return new DogDto(
                dog.getId(),
                dog.getName(),
                dog.getBreed(),
                dog.getAge()
        );
    }

    public static Dog toDog(DogDto dto) {
        return new Dog(
                dto.id(),
                dto.name(),
                dto.breed(),
                dto.age()
        );
    }

    public static List<DogDto> toDtoList(List<Dog> dogs) {
        List<DogDto> dtoList = new ArrayList<>();
        dogs.forEach(dog -> dtoList.add(toDto(dog)));
        return dtoList;
    }

    public static List<Dog> toDogList(List<DogDto> dtoList) {
        List<Dog> dogs = new ArrayList<>();
        dtoList.forEach(dto -> dogs.add(toDog(dto)));
        return dogs;
    }
}
