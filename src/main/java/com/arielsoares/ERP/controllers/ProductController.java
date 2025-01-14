package com.arielsoares.ERP.controllers;

import com.arielsoares.ERP.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/products")
public class ProductController {

    @GetMapping
    public ResponseEntity<Product> getProducts() {
        return ResponseEntity.ok(new Product(1L, "cadeira", "cadeira para sentar", 25.35));
    }

}