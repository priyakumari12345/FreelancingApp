package com.satta.priya.dao;

import com.satta.priya.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userDao extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
