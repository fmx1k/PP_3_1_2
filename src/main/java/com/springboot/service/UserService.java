package com.springboot.service;

import com.springboot.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    void deleteById(Long id);

    List<User> findAll();

    User findById(Long id);
}
