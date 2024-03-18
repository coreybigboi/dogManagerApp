package com.dogmanagerapp.controllers;

import com.dogmanagerapp.services.OwnerServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/owners")
public class OwnerController {

    private final OwnerServiceImpl ownerService;

    public OwnerController(OwnerServiceImpl ownerService) {
        this.ownerService = ownerService;
    }

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "owner endpoint works.";
    }
}
