package com.example.blog.repositories;

import com.example.blog.domain.User;
import com.example.blog.exceptions.EtAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String SQL_CREATE = "INSERT INTO users(id, password) VALUES(?, ?) ";
    private static final String SQL_COUNT_BY_ID = "SELECT COUNT(*) FROM users WHERE id = :id";
    private static final String SQL_FIND_BY_ID = "SELECT id, password, max_todo FROM users WHERE id = :id";

    RowMapper<User> rowMapper = (rs, i) -> {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setPassword(rs.getString("password"));
        user.setMax_todo(rs.getInt("max_todo"));

        return user;
    };

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int create(User user) throws EtAuthException {
        // TODO: Hash Passwrod
        try {

        } catch (Exception e) {
            throw new EtAuthException("Invalid details. Failed to create user");
        }

        return 1;
    }

    @Override
    public User findByIdAndPassword(String id, String password) throws EtAuthException {
        try {
            User user = this.findById(id);
            if (!password.equals(user.getPassword()))
                throw new EtAuthException("Invalid id/password. Please try again!");

            return user;
        } catch (EmptyResultDataAccessException e) {
            throw new EtAuthException("Invalid id/password. Please try again!");
        }
    }

    @Override
    public Integer getCountById(String id) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", id);

        return namedParameterJdbcTemplate.queryForObject(SQL_COUNT_BY_ID, map, Integer.class);
    }

    @Override
    public User findById(String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);

        return namedParameterJdbcTemplate.queryForObject(SQL_FIND_BY_ID, map, rowMapper);
    }
}
