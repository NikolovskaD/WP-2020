package com.ukim.finki.wp.chessshop.service;

import com.ukim.finki.wp.chessshop.model.User;

public interface UserService {
    User findById(String username);
}
