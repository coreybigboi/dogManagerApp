package com.dogmanagerapp.repositories;

import com.dogmanagerapp.ApplicationConfiguration;
import com.dogmanagerapp.models.Dog;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

@Singleton
public class DogRepositoryImpl implements DogRepository {
    private final EntityManager entityManager;
    private final ApplicationConfiguration applicationConfiguration;

    public DogRepositoryImpl(EntityManager entityManager, ApplicationConfiguration applicationConfiguration) {
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }
    @Override
    @ReadOnly
    public Optional<Dog> findById(long id) {
        Optional<Dog> res = Optional.ofNullable(entityManager.find(Dog.class, id));
        return Optional.ofNullable(entityManager.find(Dog.class, id));
    }

    @Override
    @Transactional
    public Dog save(String name, String breed, int age) {
        Dog dog = new Dog(name, breed, age);
        entityManager.persist(dog);
        return dog;
    }

    @Override
    @Transactional
    public Dog saveWithException(String name, String breed, int age) {
        return null;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @Transactional
    public List<Dog> findAll() {
        final String queryString = "SELECT dog FROM Dog as dog";
        final TypedQuery<Dog> query = entityManager.createQuery(queryString, Dog.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public int update(long id, String name, String breed, int age) {
        final String queryString = "UPDATE Dog dog SET name = :name, breed = :breed, age = :age WHERE id = :id";
        return entityManager.createQuery(queryString)
                .setParameter("name", name)
                .setParameter("breed", breed)
                .setParameter("age", age)
                .setParameter("id", id)
                .executeUpdate();
    }
}
