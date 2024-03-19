package com.dogmanagerapp.application;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record DogDto(
        long id,
        String name,
        String breed,
        int age
){

}
