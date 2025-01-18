package com.arielsoares.ERP.services;

import com.arielsoares.ERP.DTO.ProductDTO;
import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.exceptions.ResourceNotFoundException;
import com.arielsoares.ERP.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<ProductDTO> findAll(){

        List<Product> products = repository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();

        return products.parallelStream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Transactional
    public Product insert(Product product){
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy("Ariel");
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
        product.setUpdatedAt(LocalDateTime.now());
        product.setUpdatedBy("Ariel");
    }

    private ProductDTO productToProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.getImageUrl(),
                product.getActive()
        );
    }
}
