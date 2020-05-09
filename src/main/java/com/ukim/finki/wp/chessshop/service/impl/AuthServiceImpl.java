package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.User;
import com.ukim.finki.wp.chessshop.repository.UserRepository;
import com.ukim.finki.wp.chessshop.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getCurrentUser() {
        return this.userRepository.findById("test-user")
                .orElseGet(() -> {
                    User user = new User();
                    user.setUsername("test-user");
                    return this.userRepository.save(user);
                });
    }

    @Override
    public String getCurrentUserId() {
        return this.getCurrentUser().getUsername();
    }
}
