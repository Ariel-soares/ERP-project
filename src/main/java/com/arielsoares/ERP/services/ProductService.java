package com.arielsoares.ERP.services;

import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.exceptions.ResourceNotFoundException;
import com.arielsoares.ERP.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Product insert(Product product){
        return repository.save(product);
    }

    @Transactional
    public Product update(Long id, Product obj){
        try {
            Product product = findById(id);
            updateData(product, obj);
            return repository.save(product);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product product, Product obj) {
        product.setName(obj.getName());
        product.setDescription(obj.getDescription());
        product.setPrice(obj.getPrice());
    }
}
