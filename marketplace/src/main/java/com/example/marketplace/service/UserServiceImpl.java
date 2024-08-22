package com.example.marketplace.service;

import com.example.marketplace.model.User;
import com.example.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public Optional<User> findUserById(Long userId) {
        return userRepository.findById(userId);
    }
}
