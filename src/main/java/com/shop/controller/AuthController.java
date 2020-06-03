package com.shop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    @GetMapping("/auth")
    public ResponseEntity<String> authenticate(@RequestHeader("authorization") String authorization) {
        if (authorization.contains("dXNlcjE6cGFzc3dvcmQx")) {
            return new ResponseEntity<String>("Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
        }

    }

}