package com.dogmanagerapp.controllers;

import com.dogmanagerapp.models.Owner;
import com.dogmanagerapp.services.OwnerService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import jakarta.validation.Valid;

import java.util.List;

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
        createMockOwners();
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Owner> getOwners() {
        return this.ownerService.findAllOwners();
    }

    @Get(value = "/{id}", produces = MediaType.APPLICATION_JSON)
    public Owner getOwnerById(Long id) {
        return this.ownerService.findOwnerById(id).orElse(null);
    }

    @Post
    HttpResponse<Owner> saveOwner(@Body @Valid OwnerSaveCommand cmd) {
        Owner owner = new Owner(cmd.getName(), cmd.getAge(), cmd.getAddress());
        this.ownerService.saveOwner(owner);
        return HttpResponse.created(owner);
    }

    @Put
    HttpResponse<?> updateOwner(@Body @Valid OwnerUpdateCommand cmd) {
        Owner updated = new Owner(cmd.getName(), cmd.getAge(), cmd.getAddress());
        this.ownerService.updateOwner(cmd.getId(), updated);
        return HttpResponse.noContent();
    }

    @Delete("/{id}")
    HttpResponse<?> deleteOwner(Long id) {
        return HttpResponse.noContent();
    }

    private void createMockOwners() {
        Owner owner1 = new Owner("owner1", 30, "address1");
        Owner owner2 = new Owner("owner2", 30, "address2");
        Owner owner3 = new Owner("owner3", 30, "address3");
        this.ownerService.saveOwner(owner1);
        this.ownerService.saveOwner(owner2);
        this.ownerService.saveOwner(owner3);
    }
}
