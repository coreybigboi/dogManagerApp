package com.dogmanagerapp.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/api/dogs")
public class DogController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String index() { return "dogs works."; }
}
