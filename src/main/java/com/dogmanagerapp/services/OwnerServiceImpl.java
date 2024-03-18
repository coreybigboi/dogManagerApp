package com.dogmanagerapp.services;

import com.dogmanagerapp.models.Owner;
import com.dogmanagerapp.repositories.OwnerRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Optional<Owner> findOwnerById(long id) {
        return ownerRepository.findById(id);
    }

    @Override
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Owner saveOwner(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public void deleteOwnerById(long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public int updateOwner(long id, Owner owner) {
       return ownerRepository.update(id, owner);
    }
}
