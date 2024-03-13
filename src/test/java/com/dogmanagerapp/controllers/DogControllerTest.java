package com.dogmanagerapp.controllers;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.runtime.server.EmbeddedServer;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
public class DogControllerTest {

    @Inject
    EmbeddedServer server;

    @Inject
    @Client("/")
    HttpClient client;

//    @Test
//    void testDogResponse() {
//        String response = client.toBlocking().retrieve(HttpRequest.GET("/api/dogs"));
//        assertEquals("dogs works.", response);
//    }
}
