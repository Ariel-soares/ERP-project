package com.arielsoares.ERP.controllers;

import com.arielsoares.ERP.DTO.ProductDTO;
import com.arielsoares.ERP.entities.Product;
import com.arielsoares.ERP.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Tag(
        name = "CRUD REST APIs for products",
        description = "CRUD REST APIs in EazyBank to CREATE, UPDATE and FIND products details"
)
@RestController
@RequestMapping(value="/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @Operation(summary = "Find products list",
            description = "REST API to recover all products at once"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        List<ProductDTO> products = service.findAll();
        return ResponseEntity.ok().body(products);
    }

    @Operation(summary = "Find product by ID",
            description = "REST API to find product by it´s ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @Operation(summary = "Create product REST API",
            description = "REST API to create new product inside ERP"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody @Valid Product product){
        Product obj = service.insert(product);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @Operation(summary = "UPDATE product by ID",
            description = "REST API to update product by it´s ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable Long id){
        product = service.update(id,product);
        return ResponseEntity.ok().body(product);
    }

    @Operation(summary = "Inactivate product by ID",
            description = "REST API to inactivate product by it´s ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status OK"
    )
    @PatchMapping(value = "/inactivateProduct/{id}")
    public ResponseEntity<ProductDTO> inactivateProduct(@PathVariable Long id){
        return ResponseEntity.ok().body(service.inactivateProduct(id));
    }
}