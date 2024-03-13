package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import jakarta.inject.Singleton;

@Singleton
public class DogService {

    public Dog[] getAllDogs() {
        final int numDogs = 5;
        Dog[] dogs = new Dog[numDogs];
        for(int i = 0; i < numDogs; i++) {
            String name = "Dog " + i;
            String breed = "Breed " + i;
            int age = 1 + i;
            Dog dog = new Dog(i, name, breed, age);
            dogs[i] = dog;
        }
        return dogs;
    }
    public Dog getDobby() {
        final Dog dobby = new Dog( 1, "Dobby", "Greyhound", 6);
        return dobby;
    }
}
