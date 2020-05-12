package com.ukim.finki.wp.chessshop.service;

import com.ukim.finki.wp.chessshop.model.User;

import java.util.List;

public interface UserService {
    User findById(String username);
    List<User> findAll();
    User addUser(User user);
    void deleteUser(String username);
}
