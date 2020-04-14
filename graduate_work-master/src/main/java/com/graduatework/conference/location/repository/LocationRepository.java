package com.graduatework.conference.location.repository;

import com.graduatework.conference.location.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LocationRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public LocationRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Location getLocationById(int locationId) {
        try {
            String sql =
                    "SELECT * FROM location WHERE id = :locationId";
            return jdbcTemplate.queryForObject(sql,
                    new MapSqlParameterSource("locationId", locationId), new BeanPropertyRowMapper<>(Location.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}