package com.codermine.microsketch.alarm.listener;

import com.codermine.microsketch.alarm.dao.AlarmRepository;
import com.codermine.microsketch.alarm.model.Alarm;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.configuration.rabbitmq.annotation.Queue;
import io.micronaut.configuration.rabbitmq.annotation.RabbitListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.io.IOException;

@RabbitListener
public class RabbitAlarmListener {

    private final static Logger logger = LoggerFactory.getLogger(RabbitAlarmListener.class);

    @Inject
    private ObjectMapper objectMapper;

    @Inject
    private AlarmRepository alarmRepository;

    @Queue("alarm_queue")
    public void listen(byte[] message) throws IOException {
        Alarm alarm = objectMapper.readValue(message, Alarm.class);
        alarmRepository.save(alarm);
        logger.info("An alarm was recived from alarm_queue and saved on Alarm Table");

    }
}
