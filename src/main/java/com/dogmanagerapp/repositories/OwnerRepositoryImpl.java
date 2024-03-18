package com.dogmanagerapp.repositories;

import com.dogmanagerapp.models.Owner;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class OwnerRepositoryImpl implements OwnerRepository {
    private final EntityManager entityManager;

    public OwnerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @ReadOnly
    public Optional<Owner> findById(long id) {
        return Optional.ofNullable(entityManager.find(Owner.class, id));
    }

    @Override
    @ReadOnly
    public List<Owner> findAll() {
        final String queryString = "SELECT owner FROM Owner as owner";
        final TypedQuery<Owner> query = entityManager.createQuery(queryString, Owner.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Owner save(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        findById(id).ifPresent(entityManager::remove);
    }

    @Override
    @Transactional
    public int update(long id, Owner owner) {
        final String queryString = "UPDATE Owner owner SET name = :name, age = :age, address = :address WHERE id = :id";
        return entityManager.createQuery(queryString)
                .setParameter("name", owner.getName())
                .setParameter("age", owner.getAge())
                .setParameter("address", owner.getAddress())
                .setParameter("id", id)
                .executeUpdate();
    }
}
