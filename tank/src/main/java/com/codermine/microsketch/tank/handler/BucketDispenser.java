package com.codermine.microsketch.tank.handler;

import io.micronaut.context.annotation.Property;

import javax.inject.Singleton;

@Singleton
public class BucketDispenser implements Dispenser {

    @Property(name = "tank.dispenser-flow")
    private long flow = 5L;

    @Override
    public Long dispense() {
        return flow;
    }
}
