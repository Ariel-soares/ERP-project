package com.arielsoares.ERP.entities;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="tb_product")
@Hidden
public class Product extends BaseEntityAudit{

    @NotNull
    @NotBlank
    @Size(min = 3, max = 50, message = "O nome do produto deve ter entre 3 e 50 caracteres")
    private String name;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    @Min(value = 0, message = "O preço deve ser maior ou igual a zero.")
    private Double price;
    private String imageUrl;
    private Boolean isActive = true;

    public Product(String name, String description, Double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
