package com.graduatework.conference.conference.repository;

import com.graduatework.conference.conference.model.Conference;
import com.graduatework.conference.conference.model.ConferenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConferenceRepository {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ConferenceRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addConference(Conference conference) {
        String sql = ""
                + "INSERT INTO conference(title, description, type_id, organization_title, location_id, start_datetime, end_datetime) "
                + "VALUES(:title, :description, :type_id, :organization_title, :location_id, :start_datetime, :end_datetime)";
        jdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("title", conference.getTitle())
                .addValue("description", conference.getDescription())
                .addValue("type_id", conference.getType().getId())
                .addValue("organization_title", conference.getOrganizationTitle())
                .addValue("location_id", conference.getLocation().getId())
                .addValue("start_datetime", conference.getStartDate())
                .addValue("end_datetime", conference.getEndDate()));
    }

    public void updateConference(Conference conference) {
        String sql = ""
                + "UPDATE conference "
                + "SET title = :title, description = :description, type_id = :typeId, "
                + "organization_title = :organizationTitle, location_id = :locationId, "
                + "start_datetime = :startDatetime, end_datetime = :endDatetime "
                + "WHERE id = :conferenceId";
        jdbcTemplate.update(sql, new MapSqlParameterSource()
                .addValue("conferenceId", conference.getId())
                .addValue("title", conference.getTitle())
                .addValue("description", conference.getDescription())
                .addValue("typeId", conference.getType().getId())
                .addValue("organizationTitle", conference.getOrganizationTitle())
                .addValue("locationId", conference.getLocation().getId())
                .addValue("startDatetime", conference.getStartDate())
                .addValue("endDatetime", conference.getEndDate()));
    }

    public List<ConferenceDto> getAllConferences() {
        String sql = "SELECT * FROM conference";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ConferenceDto.class));
    }

    public void deleteConference(int conferenceId) {
        String sql = ""
                + "DELETE "
                + "FROM conference "
                + "WHERE id = :conferenceId";
        jdbcTemplate.update(sql, new MapSqlParameterSource("conferenceId", conferenceId));
    }
}