package com.shop.controller;

import java.util.List;

import com.shop.model.Manufacturer;
import com.shop.repository.ManufacturerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository repository;

    @GetMapping("/manufacturers")
    public List<Manufacturer> getManufacturers() {
        return repository.findAll();
    }

    @GetMapping("/manufacturers/{id}")
    public Manufacturer getManufacturer(@PathVariable String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Manufacturer not found: " + id));
    }

    @PostMapping("/manufacturers")
    public Manufacturer postManufacturer(@RequestBody Manufacturer manufacturer) {
        return repository.insert(manufacturer);
    }

    @PutMapping("/manufacturers/{id}")
    public Manufacturer putManufacturer(@RequestBody Manufacturer newManufacturer, @PathVariable String id)
            throws Exception {
        return repository.findById(id).map(manufacturer -> {
            manufacturer = newManufacturer;
            return repository.save(manufacturer);
        }).orElseThrow(() -> new Exception("Manufacturer not found: " + id));
    }

    @DeleteMapping("/manufacturers/{id}")
    public void deleteManufacturer(@PathVariable String id) {
        repository.deleteById(id);
    }

}