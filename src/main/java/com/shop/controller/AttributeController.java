package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Attribute;
import com.shop.repository.AttributeRepository;

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
public class AttributeController {

    @Autowired
    private AttributeRepository attributeRepository;

    @GetMapping("/attributes")
    public List<Attribute> getAttributes() {
        return attributeRepository.findAll();
    }

    @GetMapping("/attributes/{id}")
    public Attribute getAttribute(@PathVariable String id) {
        return attributeRepository.findById(id).orElseThrow(() -> new NotFoundException("Attribute not found: " + id));
    }

    @PostMapping("/attributes")
    public Attribute postAttribute(@RequestBody Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @PutMapping("/attributes/{id}")
    public Attribute putAttribute(@RequestBody Attribute newAttribute, @PathVariable String id) {
        return attributeRepository.findById(id).map(attribute -> {
            return attributeRepository.save(newAttribute);
        }).orElseThrow(() -> new NotFoundException("Attribute not found: " + id));
    }

    @DeleteMapping("/attributes/{id}")
    public void deleteAttribute(@PathVariable String id) {
        attributeRepository.deleteById(id);
    }
}