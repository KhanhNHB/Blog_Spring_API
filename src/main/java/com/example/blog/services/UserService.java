package com.example.blog.services;

import com.example.blog.exceptions.EtAuthException;
import com.example.blog.domain.User;

public interface UserService {
    User validateUser(String id, String password) throws EtAuthException;

    User registrerUser(User user) throws EtAuthException;
}
