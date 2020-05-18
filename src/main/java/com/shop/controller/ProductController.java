package com.shop.controller;

import java.util.List;

import com.shop.model.Product;
import com.shop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) throws Exception {
        return repository.findById(id).orElseThrow(() -> new Exception("Product not found: " + id));
    }

    @PostMapping("/products")
    public Product postProduct(@RequestBody Product product) {
        return repository.insert(product);
    }

    @PutMapping("/products/{id}")
    public Product putProduct(@RequestBody Product newProduct, @PathVariable String id) throws Exception {
        return repository.findById(id).map(product -> {
            product = newProduct;
            return repository.save(product);
        }).orElseThrow(() -> new Exception("Product not found: " + id));
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        repository.deleteById(id);
    }

}