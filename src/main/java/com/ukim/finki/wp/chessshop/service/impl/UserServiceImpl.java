/*
package com.ukim.finki.wp.chessshop.service.impl;

import com.ukim.finki.wp.chessshop.model.User;
import com.ukim.finki.wp.chessshop.model.exceptions.UserNotFoundException;
import com.ukim.finki.wp.chessshop.repository.UserRepository;
import com.ukim.finki.wp.chessshop.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    */
/*@Override
    public User findById(String username) {
        return this.userRepository.findById(username).orElseThrow(() -> new UserNotFoundException(username));
    }*//*


    @Override
    public User findById(String username) {
        return null;
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(Long id) {
        userRepository.delete(id);
        return "{'message':'User deleted successfully.'}";
    }
}
*/
