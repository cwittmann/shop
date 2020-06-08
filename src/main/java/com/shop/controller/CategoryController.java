package com.shop.controller;

import java.util.List;

import com.shop.exception.NotFoundException;
import com.shop.model.Category;
import com.shop.repository.CategoryRepository;

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
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getCategorys() {
        return categoryRepository.findAll();
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable String id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found: " + id));
    }

    @PostMapping("/categories")
    public Category postCategory(@RequestBody Category category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/categories/{id}")
    public Category putCategory(@PathVariable String id, @RequestBody Category newCategory) {
        return categoryRepository.findById(id).map(category -> {
            return categoryRepository.save(newCategory);
        }).orElseThrow(() -> new NotFoundException("Category not found: " + id));
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable String id) {
        categoryRepository.deleteById(id);
    }
}