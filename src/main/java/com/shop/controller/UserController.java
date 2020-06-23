package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.User;
import com.shop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);

    @GetMapping("/users")
    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.password = "";
        }

        return users;
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found: " + id));
        user.password = "";
        return user;
    }

    @PostMapping("/users")
    public User postUser(@RequestBody User user) {
        user.password = encoder.encode(user.password);
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User putUser(@RequestBody User newUser, @PathVariable String id) {
        return userRepository.findById(id).map(user -> {
            newUser.password = encoder.encode(newUser.password);
            return userRepository.save(newUser);
        }).orElseThrow(() -> new NotFoundException("User not found: " + id));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}