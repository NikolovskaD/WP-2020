package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.User;
import com.ukim.finki.wp.chessshop.model.exceptions.UserNotFoundException;
import com.ukim.finki.wp.chessshop.repository.UserRepository;
import com.ukim.finki.wp.chessshop.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String username) {
        return this.userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }
}
