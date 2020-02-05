package com.codermine.microsketch.tank.handler;

import io.micronaut.context.annotation.Primary;

import javax.inject.Singleton;

@Singleton
@Primary
public class DropDispenser implements Dispenser {

    @Override
    public Long dispense() {
        return 1L;
    }
}
