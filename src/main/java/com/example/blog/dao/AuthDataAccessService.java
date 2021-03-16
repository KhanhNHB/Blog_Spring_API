package com.example.blog.dao;

import com.example.blog.model.SignIn;
import com.example.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository()
public class AuthDataAccessService implements AuthDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    RowMapper<User> rowMapper = (rs, i) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setMax_todo(rs.getInt("max_todo"));

        return user;
    };

    @Override
    public String signIn(SignIn signIn) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();

        mapSqlParameterSource.addValue("id", signIn.getId());
        mapSqlParameterSource.addValue("password", signIn.getPassword());

        String sql = "SELECT * FROM users WHERE id = :id AND password = :password";

        List<User> users = namedParameterJdbcTemplate.query(sql, mapSqlParameterSource, rowMapper);

        if (users.size() > 0) {
            return users.get(0).getId();
        }

        return null;
    }
}
