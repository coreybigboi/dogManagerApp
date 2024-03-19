package com.dogmanagerapp.application;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record OwnerDto(
        long id,
        String name,
        int age,
        String address
) {
}
