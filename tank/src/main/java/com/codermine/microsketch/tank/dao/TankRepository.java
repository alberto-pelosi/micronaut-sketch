package com.codermine.microsketch.tank.dao;

import com.codermine.microsketch.tank.model.Tank;
import io.micronaut.data.repository.CrudRepository;

public interface TankRepository extends CrudRepository<Tank, Long> {

}
