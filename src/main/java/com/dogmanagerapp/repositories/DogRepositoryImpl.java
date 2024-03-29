package com.dogmanagerapp.repositories;

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

    public DogRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    @ReadOnly
    public Optional<Dog> findById(long id) {
        Optional<Dog> res = Optional.ofNullable(entityManager.find(Dog.class, id));
        return Optional.ofNullable(entityManager.find(Dog.class, id));
    }

    @Override
    @ReadOnly
    public List<Dog> findAll() {
        final String queryString = "SELECT dog FROM Dog as dog";
        final TypedQuery<Dog> query = entityManager.createQuery(queryString, Dog.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Dog save(Dog dog) {
        entityManager.persist(dog);
        return dog;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @Transactional
    public int update(long id, Dog dog) {
        final String queryString = "UPDATE Dog dog SET name = :name, breed = :breed, age = :age WHERE id = :id";
        return entityManager.createQuery(queryString)
                .setParameter("name", dog.getName())
                .setParameter("breed", dog.getBreed())
                .setParameter("age", dog.getAge())
                .setParameter("id", id)
                .executeUpdate();
    }
}
