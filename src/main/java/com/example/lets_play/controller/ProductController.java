package com.example.lets_play.controller;
import com.example.lets_play.model.Product;
import com.example.lets_play.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller
@RequestMapping("/api/products") // Base path for all methods in this controller
public class ProductController {

    @Autowired // Inject the repository
    private ProductRepository productRepository;

    // Publicly Accessible: GET /api/products
    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Publicly Accessible: GET /api/products/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        return productRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // **RESTRICTED** (Admin/User): POST /api/products
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // **RESTRICTED** (Admin): DELETE /api/products/{id}
    // ... update and delete methods follow a similar pattern
}