package com.codermine.microsketch.tank.service;

import com.codermine.microsketch.tank.dao.TankRepository;
import com.codermine.microsketch.tank.model.Tank;
import io.micronaut.scheduling.annotation.Scheduled;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TankPatrol {

    @Inject
    private TankRepository tankRepository;

    @Scheduled(fixedDelay = "90s")
    public void checkLevel() {
        List<Tank> tanks = tankRepository.findAll();
        for(Tank tank : tanks) {

        }
    }
}
