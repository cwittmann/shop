package com.shop.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.shop.model.User;
import com.shop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestHeader("authorization") String authorization,
            @RequestBody String[] userPassword) throws NoSuchAlgorithmException {

        String user = userPassword[0];
        String password = userPassword[1];

        User userFromDb = userRepository.findByUserName(user);

        if (userFromDb != null && passwordMatches(password, userFromDb.password)) {

            return new ResponseEntity<String>("Successful", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Error", HttpStatus.UNAUTHORIZED);
    }

    private Boolean passwordMatches(String unencodedPassword, String encodedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        return encoder.matches(unencodedPassword, encodedPassword);
    }
}