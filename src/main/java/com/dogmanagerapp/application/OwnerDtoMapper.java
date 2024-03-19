package com.dogmanagerapp.application;

import com.dogmanagerapp.models.Owner;

public class OwnerDtoMapper {

    public static OwnerDto toDto(Owner owner) {
        return new OwnerDto(
                owner.getId(),
                owner.getName(),
                owner.getAge(),
                owner.getAddress()
        );
    }

    public static Owner toOwner(OwnerDto dto) {
        return new Owner(
                dto.id(),
                dto.name(),
                dto.age(),
                dto.address()
        );
    }
}
