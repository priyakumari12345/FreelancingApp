package com.satta.priya.service;

import com.satta.priya.dao.userDao;
import com.satta.priya.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    private final userDao userdao;

    @Autowired
    public userService(userDao userdao) {
        this.userdao = userdao;
    }
    public User findByUsername(String username) {
        return userdao.findByUsername(username);
    }
}
