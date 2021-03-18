package com.example.blog.services;

import com.example.blog.domain.User;
import com.example.blog.exceptions.EtAuthException;
import com.example.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String id, String password) throws EtAuthException {
        return userRepository.findByIdAndPassword(id, password);
    }

    @Override
    public User registrerUser(User user) throws EtAuthException {
//        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        // TODO: check is empty filed

        Integer count = userRepository.getCountById(user.getId());
        if (count > 0) {
            throw new EtAuthException("Id already is user");
        }

        Integer userId = userRepository.create(user);
        return userRepository.findById(userId.toString());
    }
}
