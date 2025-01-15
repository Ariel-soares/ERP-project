package com.arielsoares.ERP.services;

import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product insert(Product product){
        return repository.save(product);
    }

}
