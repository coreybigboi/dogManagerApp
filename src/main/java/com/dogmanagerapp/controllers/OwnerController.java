package com.dogmanagerapp.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/owners")
public class OwnerController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() {
        return "owner endpoint works.";
    }
}
