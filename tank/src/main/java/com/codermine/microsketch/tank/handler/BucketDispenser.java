package com.codermine.microsketch.tank.handler;

import javax.inject.Singleton;

@Singleton
public class BucketDispenser implements Dispenser {
    @Override
    public Long dispense() {
        return 5L;
    }
}
