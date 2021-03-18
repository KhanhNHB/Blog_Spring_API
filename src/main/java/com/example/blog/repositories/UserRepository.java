package com.example.blog.repositories;

import com.example.blog.exceptions.EtAuthException;
import com.example.blog.domain.User;

public interface UserRepository {

    int create(User user) throws EtAuthException;

    User findByIdAndPassword(String id, String password) throws EtAuthException;

    Integer getCountById(String id);

    User findById(String id);
}