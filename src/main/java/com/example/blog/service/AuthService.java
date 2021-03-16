package com.example.blog.service;

import com.example.blog.dao.AuthDao;
import com.example.blog.model.SignIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthDao authDao;

    @Autowired
    public AuthService(AuthDao authDao) {
        this.authDao = authDao;
    }

    public String signIn(SignIn signIn) {
        return this.authDao.signIn(signIn);
    }
}
