package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Dog;
import jakarta.inject.Singleton;

@Singleton
public class DogService {
    public Dog getDobby() {
        final Dog dobby = new Dog( 1, "Dobby", "Greyhound", 6);
        return dobby;
    }
}
