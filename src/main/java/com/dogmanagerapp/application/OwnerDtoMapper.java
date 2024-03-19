package com.dogmanagerapp.application;

import com.dogmanagerapp.models.Owner;

import java.util.ArrayList;
import java.util.List;

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

    public static List<OwnerDto> toDtoList(List<Owner> owners) {
        List<OwnerDto> dtoList = new ArrayList<>();
        owners.forEach(owner -> dtoList.add(toDto(owner)));
        return dtoList;
    }

    public static List<Owner> toOwnerList(List<OwnerDto> dtoList) {
        List<Owner> owners = new ArrayList<>();
        dtoList.forEach(dto -> owners.add(toOwner(dto)));
        return owners;
    }
}
