package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Role;
import com.shop.repository.RoleRepository;

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
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable String id) {
        return roleRepository.findById(id).orElseThrow(() -> new NotFoundException("Role Right not found: " + id));
    }

    @PostMapping("/roles")
    public Role postRole(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @PutMapping("/roles/{id}")
    public Role putRole(@RequestBody Role newRole, @PathVariable String id) {
        return roleRepository.findById(id).map(role -> {
            return roleRepository.save(newRole);
        }).orElseThrow(() -> new NotFoundException("Role not found: " + id));
    }

    @DeleteMapping("/roles/{id}")
    public void deleteRole(@PathVariable String id) {
        roleRepository.deleteById(id);
    }
}