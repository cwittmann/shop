package com.shop.controller;

import java.util.Base64;

import com.shop.model.User;
import com.shop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestHeader("authorization") String authorization) {

        String base64Credentials = authorization.substring("Basic".length()).trim();
        String decoded = new String(Base64.getDecoder().decode(base64Credentials));
        String user = decoded.split(":")[0];
        String password = decoded.split(":")[1];

        User userFromDb = userRepository.findByUserName(user);

        if (userFromDb != null && userFromDb.password.equals(password)) {
            return new ResponseEntity<String>("Successful", HttpStatus.OK);
        }

        return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
    }
}