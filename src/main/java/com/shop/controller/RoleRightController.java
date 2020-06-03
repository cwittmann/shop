package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.RoleRight;
import com.shop.repository.RoleRightRepository;

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
public class RoleRightController {

    @Autowired
    private RoleRightRepository roleRightRepository;

    @GetMapping("/roleRights")
    public List<RoleRight> getRoleRights() {
        return roleRightRepository.findAll();
    }

    @GetMapping("/roleRights/{id}")
    public RoleRight getRoleRight(@PathVariable String id) {
        return roleRightRepository.findById(id).orElseThrow(() -> new NotFoundException("Role Right not found: " + id));
    }

    @PostMapping("/roleRights")
    public RoleRight postRoleRight(@RequestBody RoleRight roleRight) {
        return roleRightRepository.save(roleRight);
    }

    @PutMapping("/roleRights/{id}")
    public RoleRight putRoleRight(@RequestBody RoleRight newRoleRight, @PathVariable String id) {
        return roleRightRepository.findById(id).map(roleRight -> {
            return roleRightRepository.save(newRoleRight);
        }).orElseThrow(() -> new NotFoundException("RoleRight not found: " + id));
    }

    @DeleteMapping("/roleRights/{id}")
    public void deleteRoleRight(@PathVariable String id) {
        roleRightRepository.deleteById(id);
    }
}