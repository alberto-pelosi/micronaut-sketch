package com.codermine.microsketch.alarm.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import java.time.LocalDateTime;

@MappedEntity
public class Alarm {

    @Id
    @GeneratedValue
    private Long id;

    private Long tankId;

    private LocalDateTime time;

    private Long currentLevel;

    private Long capacity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTankId() {
        return tankId;
    }

    public void setTankId(Long tankId) {
        this.tankId = tankId;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Long getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(Long currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id=" + id +
                ", tankId=" + tankId +
                ", time=" + time +
                ", currentLevel=" + currentLevel +
                ", capacity=" + capacity +
                '}';
    }
}

