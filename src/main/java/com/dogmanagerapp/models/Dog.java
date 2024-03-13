package com.dogmanagerapp.models;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable.Serializable()
public class Dog {

    private final int id;
    private final String name;
    private final String breed;
    private final int age;

    public Dog(int id, String name, String breed, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }
}
