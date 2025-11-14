package com.repdoctor.product.controller;

import com.repdoctor.product.model.Product;
import com.repdoctor.product.repo.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Product> list() { return repo.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Product> get(@PathVariable Long id) {
        Optional<Product> p = repo.findById(id);
        return p.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return repo.save(p); }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product p) {
        return repo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setDescription(p.getDescription());
            existing.setQuantity(p.getQuantity());
            repo.save(existing);
            return ResponseEntity.ok(existing);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repo.existsById(id)) { repo.deleteById(id); return ResponseEntity.noContent().build(); }
        return ResponseEntity.notFound().build();
    }
}
