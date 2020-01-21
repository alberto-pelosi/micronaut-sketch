package com.codermine.microsketch.tank.service;

import com.codermine.microsketch.tank.dao.TankRepository;
import com.codermine.microsketch.tank.model.Tank;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TankService {

    @Inject
    private TankRepository tankRepository;

    public Tank create(Tank tank){
        return tankRepository.save(tank);
    }

    public Tank update(Tank tank) {
        return tankRepository.update(tank);
    }

    public void delete(Tank tank) {
        tankRepository.delete(tank);
    }

    public List<Tank> findAll() {
        return tankRepository.findAll();
    }

    public Tank read(Long id) {
        return tankRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Tank> findByName(String name) {
        return tankRepository.findByName(name);
    }


}
