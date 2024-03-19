package com.dogmanagerapp.application;

public record OwnerDto(
        long id,
        String name,
        int age,
        String address
) {
}
