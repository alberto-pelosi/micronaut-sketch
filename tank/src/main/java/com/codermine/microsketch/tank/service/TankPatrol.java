package com.codermine.microsketch.tank.service;

import com.codermine.microsketch.tank.dao.TankRepository;
import com.codermine.microsketch.tank.model.Alarm;
import com.codermine.microsketch.tank.model.Tank;
import com.codermine.microsketch.tank.rabbit.RabbitAlarmClient;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.scheduling.annotation.Scheduled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Singleton
public class TankPatrol {

    private final static Logger logger = LoggerFactory.getLogger(TankPatrol.class);

    @Inject
    private TankRepository tankRepository;
    
    @Inject
    private RabbitAlarmClient rabbitAlarmClient;
    
    @Inject
    private ObjectMapper objectMapper;


    @Scheduled(fixedDelay = "60s")
    public void checkLevel() throws JsonProcessingException {
        List<Tank> tanks = tankRepository.findAll();
        for(Tank tank : tanks) {
            if(tank.getCurrentLevel().compareTo(tank.getCapacity())>=0) {
                sendAlarm(tank);
            }
        }
    }

    private void sendAlarm(Tank tank) throws JsonProcessingException {
        Alarm alarm = new Alarm();
        alarm.setTankId(tank.getId());
        alarm.setTime(LocalDateTime.now(ZoneId.of("UTC")));
        alarm.setCurrentLevel(tank.getCurrentLevel());
        alarm.setCapacity(tank.getCapacity());
        byte[] data = objectMapper.writeValueAsBytes(alarm);

        rabbitAlarmClient.sendAlarm(data);
        logger.info("Alarm sent for tank " + tank);

    }
}
