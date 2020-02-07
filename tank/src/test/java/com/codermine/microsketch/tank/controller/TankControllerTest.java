package com.codermine.microsketch.tank.controller;

import com.codermine.microsketch.tank.model.Tank;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@MicronautTest
public class TankControllerTest {


    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void createTankTest() {
        Tank tank = new Tank();
        tank.setName("mytank");
        tank.setCurrentLevel(0L);
        tank.setCapacity(100L);
        HttpRequest request = HttpRequest.POST("/tanks", tank);
        HttpResponse<Tank> response =  httpClient.toBlocking().exchange(request, Tank.class);

        Assertions.assertNotNull(response);
        Assertions.assertEquals("mytank", response.body().getName());
        Assertions.assertEquals(100, response.body().getCapacity());
    }

}
