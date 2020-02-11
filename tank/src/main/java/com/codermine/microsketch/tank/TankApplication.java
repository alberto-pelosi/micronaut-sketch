package com.codermine.microsketch.tank;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "micronautsketch",
                version = "v1",

                description = "That's one small step for [a] man")
)
public class TankApplication {

    public static void main(String[] args) {
        Micronaut.run(TankApplication.class);
    }
}