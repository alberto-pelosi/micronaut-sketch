package com.codermine.microsketch.tank.handler;

import io.micronaut.context.annotation.Primary;

import javax.inject.Singleton;

@Singleton
@Primary
public class DropDispenser implements Dispenser {

    public static final long quantity = 1L;

    @Override
    public Long dispense() {
        return quantity;
    }
}
