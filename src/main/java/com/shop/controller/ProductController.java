package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;

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
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable String id) {
        return productRepository.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @PostMapping("/products")
    public Product postProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public Product putProduct(@RequestBody Product newProduct, @PathVariable String id) {
        return productRepository.findById(id).map(product -> {
            return productRepository.save(newProduct);
        }).orElseThrow(() -> new NotFoundException("Product not found: " + id));
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id) {
        productRepository.deleteById(id);
    }
}