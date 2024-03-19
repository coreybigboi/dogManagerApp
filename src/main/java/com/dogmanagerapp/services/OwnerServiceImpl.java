package com.dogmanagerapp.services;

import com.dogmanagerapp.application.OwnerDto;
import com.dogmanagerapp.application.OwnerDtoMapper;
import com.dogmanagerapp.models.Owner;
import com.dogmanagerapp.repositories.OwnerRepository;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.Optional;

@Singleton
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Optional<OwnerDto> findOwnerById(long id) {
        Optional<Owner> owner = ownerRepository.findById(id);
        return owner.map(OwnerDtoMapper::toDto);
    }

    @Override
    public List<OwnerDto> findAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return OwnerDtoMapper.toDtoList(owners);
    }

    @Override
    public OwnerDto saveOwner(Owner owner) {
        Owner result = ownerRepository.save(owner);
        return OwnerDtoMapper.toDto(result);
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
