package com.arielsoares.ERP.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "ProductDTO",
        description = "Schema to hold Product informations"
)
public record ProductDTO(Long id, String name, Double price, String description, String imageUrl, Boolean isActive){}
