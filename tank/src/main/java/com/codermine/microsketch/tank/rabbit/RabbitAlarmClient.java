package com.codermine.microsketch.tank.rabbit;

import io.micronaut.configuration.rabbitmq.annotation.RabbitClient;

@RabbitClient("alarm_exchange")
public interface RabbitAlarmClient {

    void sendAlarm(byte[] alarm);
}
