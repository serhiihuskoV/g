package com.graduatework.conference.type.repository;

import com.graduatework.conference.type.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TypeRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public TypeRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Type getTypeById(int typeId) {
        try {
            String sql =
                    "SELECT * FROM type WHERE id = :typeId";
            return jdbcTemplate.queryForObject(sql,
                    new MapSqlParameterSource("typeId", typeId), new BeanPropertyRowMapper<>(Type.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}