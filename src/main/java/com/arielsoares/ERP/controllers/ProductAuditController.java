package com.arielsoares.ERP.controllers;

import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.services.ProductAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/productsAudit")
public class ProductAuditController {

    @Autowired
    private ProductAuditService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(productService.findById(id));
    }

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping
    public List<Product> findByUserId(Long userId) {
        return null;
    }
}
