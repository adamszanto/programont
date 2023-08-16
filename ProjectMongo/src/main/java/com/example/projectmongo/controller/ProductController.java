package com.example.projectmongo.controller;

import co.elastic.clients.elasticsearch.nodes.Http;
import com.example.projectmongo.service.model.Product;
import com.example.projectmongo.repository.ProductRepository;
import com.example.projectmongo.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> sendProduct(@RequestBody final Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> receiveProduct() {
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<?> findProduct(@PathVariable final String productId) {
        try {
            Product product = productService.getProductById(productId);
            if(product == null) {
                throw new Exception("Cannot find product with id: " + productId);
            }
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> receiveProductSearchResult(@RequestParam String name) {
        List<Product> searchResult = productService.searchProductByName(name);
        return new ResponseEntity<>(searchResult, HttpStatus.OK);
    }
}
