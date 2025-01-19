package com.arielsoares.ERP.services;

import com.arielsoares.ERP.entities.DTO.ProductDTO;
import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.exceptions.ResourceNotFoundException;
import com.arielsoares.ERP.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;


    public List<ProductDTO> findAll(){

        List<Product> products = repository.findAll();
        return products.parallelStream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO findById(Long id){
        Product obj = repository.findById(id).orElseThrow();
        return productToProductDTO(obj);
    }

    public List<ProductDTO> findByName(String name){

        List<Product> products = repository.findByName(name);
        return products.parallelStream()
                .map(this::productToProductDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO){

        Product product = productFromDTO(productDTO);
        product.setCreatedAt(LocalDateTime.now());
        product.setCreatedBy("Ariel");

        return productToProductDTO(repository.save(product));
    }

    @Transactional
    public ProductDTO update(Long id, Product obj){
        try {
            Product product = repository.findById(id).orElseThrow();
            updateData(product, obj);

            product = repository.save(product);

            return productToProductDTO(product);
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

    public ProductDTO inactivateProduct(Long id){
        Product product = repository.findById(id).orElseThrow();

        if (product.getActive() == false) throw new RuntimeException("Product is already inactive");

        product.setActive(false);
        product = repository.save(product);
        ProductDTO obj = productToProductDTO(product);
        return obj;
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

    private Product productFromDTO(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.name());
        product.setDescription(productDTO.description());
        product.setImageUrl(productDTO.imageUrl());
        product.setPrice(productDTO.price());
        return product;
    }
}
