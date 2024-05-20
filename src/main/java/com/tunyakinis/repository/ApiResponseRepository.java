package com.tunyakinis.repository;

import com.tunyakinis.model.ApiResponse;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ApiResponseRepository extends CrudRepository<ApiResponse, Long> {

}
