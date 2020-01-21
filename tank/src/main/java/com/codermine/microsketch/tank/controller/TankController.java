package com.codermine.microsketch.tank.controller;

import com.codermine.microsketch.tank.model.Tank;
import com.codermine.microsketch.tank.service.TankService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import javax.inject.Inject;
import java.util.List;

@Controller(TankController.TANKS)
public class TankController {
    public static final String TANKS = "/tanks";

    @Inject
    TankService tankService;



    @Post(MediaType.APPLICATION_JSON)
    @Operation(summary = "Insert new tank", description = "Insert new tank" )
    @Tag(name = "Tank")
    public Tank create(@Body Tank tank) {
        return tankService.create(tank);
    }

    @Get(uri ="/{id}", produces = MediaType.APPLICATION_JSON)
    @Operation(summary = "Tank Detail", description = "Tank Detail" )
    @Tag(name = "Tank")
    public Tank read(Long id) {
        return tankService.read(id);
    }

    @Get(MediaType.APPLICATION_JSON)
    @Operation(summary = "List all Tanks", description = "List all Tanks" )
    @Tag(name = "Tank")
    public List<Tank> findAll() {
        return tankService.findAll();
    }

    @Get(MediaType.APPLICATION_JSON)
    @Operation(summary = "Find Tank By Name", description = "Find Tank By Name" )
    @Tag(name = "Tank")
    public List<Tank> findByName(String name) {
        return tankService.findByName(name);
    }



}
