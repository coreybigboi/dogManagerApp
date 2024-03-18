package com.dogmanagerapp.models;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
@Serdeable.Serializable()
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String name;

    @Column
    private String breed;

    @Column
    private int age;

    public Dog() {

    }

    public Dog(int id, String name, String breed, int age) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
