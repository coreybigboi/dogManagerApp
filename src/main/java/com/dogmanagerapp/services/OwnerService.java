package com.dogmanagerapp.services;

import com.dogmanagerapp.application.OwnerDto;
import com.dogmanagerapp.models.Owner;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface OwnerService {
    Optional<OwnerDto> findOwnerById(long id);
    List<OwnerDto> findAllOwners();
    OwnerDto saveOwner(@NotNull Owner owner);
    void deleteOwnerById(long id);
    int updateOwner(long id, @NotNull Owner owner);
}
