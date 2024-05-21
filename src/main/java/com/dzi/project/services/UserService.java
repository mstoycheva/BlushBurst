package com.dzi.project.services;


import com.dzi.project.models.User;
import com.dzi.project.repositories.UserRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersByFirstNameOrLastName(String firstName, String lastName) {
        if (firstName != null && !firstName.isEmpty() && lastName != null && !lastName.isEmpty()) {
            return userRepository.findByFirstNameOrLastName(firstName, lastName);
        } else if (firstName != null && !firstName.isEmpty()) {
            return userRepository.findByFirstName(firstName);
        } else if (lastName != null && !lastName.isEmpty()) {
            return userRepository.findByLastName(lastName);
        } else {
            return List.of(); // Return an empty list if both parameters are null or empty
        }
    }

    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public boolean isUsernameAvailable(String username) {
        return userRepository.findByUsername(username) == null;
    }

    public void createUser(User user){
        userRepository.saveAndFlush(user);
    }

    public void editUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUsername(username);
    }
}