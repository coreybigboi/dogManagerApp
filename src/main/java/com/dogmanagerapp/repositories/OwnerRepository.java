package com.dogmanagerapp.repositories;

import com.dogmanagerapp.models.Owner;

import java.util.List;
import java.util.Optional;

public interface OwnerRepository {
    Optional<Owner> findById(long id);
    List<Owner> findAll();
    Owner save(Owner owner);
    void deleteById(long id);
    int update(long id, Owner owner);

}
