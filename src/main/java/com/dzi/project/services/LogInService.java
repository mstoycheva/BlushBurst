package com.dzi.project.services;

import com.dzi.project.models.User;
import com.dzi.project.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LogInService {
    @Autowired
    private UserRepository userRepository;

    public LogInService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean logIn(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(!Objects.isNull(user)) {
            return user.getPassword().equals(password);
        }
        return false;
    }

}
