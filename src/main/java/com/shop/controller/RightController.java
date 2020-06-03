package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Right;
import com.shop.repository.RightRepository;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RightController {

    @Autowired
    private RightRepository rightRepository;

    @GetMapping("/rights")
    public List<Right> getRights() {
        return rightRepository.findAll();
    }

    @GetMapping("/rights/{id}")
    public Right getRight(@PathVariable String id) {
        return rightRepository.findById(id).orElseThrow(() -> new NotFoundException("Right not found: " + id));
    }

    @PostMapping("/rights")
    public Right postRight(@RequestBody Right right) {
        return rightRepository.save(right);
    }

    @PutMapping("/rights/{id}")
    public Right putRight(@RequestBody Right newRight, @PathVariable String id) {
        return rightRepository.findById(id).map(right -> {
            return rightRepository.save(newRight);
        }).orElseThrow(() -> new NotFoundException("Right not found: " + id));
    }

    @DeleteMapping("/rights/{id}")
    public void deleteRight(@PathVariable String id) {
        rightRepository.deleteById(id);
    }
}