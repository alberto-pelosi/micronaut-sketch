package com.codermine.microsketch.tank.service;

import com.codermine.microsketch.tank.dao.TankRepository;
import com.codermine.microsketch.tank.handler.Dispenser;
import com.codermine.microsketch.tank.model.Tank;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TankFiller {


    private final static Logger logger = LoggerFactory.getLogger(TankFiller.class);


    private TankRepository tankRepository;


    private Dispenser dispenser;

    @Inject
    public TankFiller(TankRepository tankRepository, @Named("BucketDispenser") Dispenser dispenser) {
        this.tankRepository = tankRepository;
        this.dispenser = dispenser;
    }


    @Scheduled(fixedDelay = "10s")
    public void fill() {
        logger.info("Periodical tank filling");
        List<Tank> tanks = tankRepository.findAll();
        for(Tank tank : tanks) {
            Long currentLevel = tank.getCurrentLevel();
            tankRepository.update(tank.getId(), currentLevel + dispenser.dispense() );
            logger.info("Current level was updated for tank " + tank);

        }
    }





    //first example
    /*@Scheduled(fixedDelay = "60s")
    public void fill() {
        logger.info("Periodical tank filling");
        List<Tank> tanks = tankRepository.findAll();
        for(Tank tank : tanks) {
            Long currentLevel = tank.getCurrentLevel();
            tankRepository.update(tank.getId(), currentLevel +1 );
            logger.info("Current level was updated for tank " + tank);

        }
    }*/
}
