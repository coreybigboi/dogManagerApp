package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Owner;
import com.dogmanagerapp.services.OwnerService;
import com.dogmanagerapp.services.OwnerServiceImpl;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.List;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Owner> index() {
        return this.ownerService.findAllOwners();
    }
}
