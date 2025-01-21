package com.arielsoares.ERP.services;

import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAuditService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }


}
