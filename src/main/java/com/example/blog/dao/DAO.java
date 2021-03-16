package com.example.blog.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> list();

    Optional<T> get(String id);

    int create(T t);

    int delete(String id);

    int update(String id, T t);
}
