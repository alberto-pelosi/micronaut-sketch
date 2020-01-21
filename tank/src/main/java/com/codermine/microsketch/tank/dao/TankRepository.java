package com.codermine.microsketch.tank.dao;

import com.codermine.microsketch.tank.model.Tank;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface TankRepository extends CrudRepository<Tank, Long> {

    public abstract List<Tank> findAll();

    public abstract List<Tank> findByName(String name);

}
