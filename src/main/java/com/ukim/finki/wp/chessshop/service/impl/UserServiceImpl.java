package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.User;
import com.ukim.finki.wp.chessshop.repository.UserRepository;
import com.ukim.finki.wp.chessshop.service.UserService;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(String username) {
        return this.userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = this.userRepository.findByUsername(username);
        userRepository.delete(user);
    }
}
