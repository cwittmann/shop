package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Manufacturer;
import com.shop.repository.ManufacturerRepository;

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
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getManufacturers() {
        return manufacturerRepository.findAll();
    }

    @GetMapping("/manufacturers/{id}")
    public Manufacturer getManufacturer(@PathVariable String id) {
        return manufacturerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Manufacturer not found: " + id));
    }

    @PostMapping("/manufacturers")
    public Manufacturer postManufacturer(@RequestBody Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

    @PutMapping("/manufacturers/{id}")
    public Manufacturer putManufacturer(@PathVariable String id, @RequestBody Manufacturer newManufacturer) {
        return manufacturerRepository.findById(id).map(manufacturer -> {
            return manufacturerRepository.save(newManufacturer);
        }).orElseThrow(() -> new NotFoundException("Manufacturer not found: " + id));
    }

    @DeleteMapping("/manufacturers/{id}")
    public void deleteManufacturer(@PathVariable String id) {
        manufacturerRepository.deleteById(id);
    }
}