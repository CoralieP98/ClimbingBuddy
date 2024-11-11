package com.CoralieP98.stats.Repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserStatRepository {

    private final JdbcTemplate jdbcTemplate;


    public UserStatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> callSPGraphTechnic(int id) {
        String sql = "CALL TechniqueStatSp(?)";
        return jdbcTemplate.queryForList(sql, id);
    }
}
