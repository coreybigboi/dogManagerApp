package com.dogmanagerapp.controllers;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/dogs")
public class dogsController {

    @Get(produces = MediaType.TEXT_PLAIN)
    public String test() {
        return "dogs works.";
    }
}
