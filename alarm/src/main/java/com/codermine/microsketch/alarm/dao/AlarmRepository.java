package com.codermine.microsketch.alarm.dao;

import com.codermine.microsketch.alarm.model.Alarm;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public abstract class AlarmRepository implements CrudRepository<Alarm, Long> {
}
