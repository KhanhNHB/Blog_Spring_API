package com.example.blog.dao;

import com.example.blog.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthJdbcDAO implements DAO<User> {
    private static final Logger log = LoggerFactory.getLogger(AuthJdbcDAO.class);
    private JdbcTemplate jdbcTemplate;

    public AuthJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    RowMapper<User> rowMapper = (rs, i) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setMax_todo(rs.getInt("max_todo"));

        return user;
    };

    @Override
    public List<User> list() {
        String sql = "SELECT * FROM user";
        jdbcTemplate.query(sql, rowMapper);
        return null;
    }

    @Override
    public Optional<User> get(String id) {
        return Optional.empty();
    }

    @Override
    public int create(User user) {
        return 0;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    @Override
    public int update(String id, User user) {
        return 0;
    }
}
