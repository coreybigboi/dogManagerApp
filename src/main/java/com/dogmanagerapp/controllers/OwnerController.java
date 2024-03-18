package com.dogmanagerapp.controllers;

import com.dogmanagerapp.services.OwnerService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "owner endpoint works.";
    }
}
