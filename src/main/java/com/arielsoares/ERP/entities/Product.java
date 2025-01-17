package com.arielsoares.ERP.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="tb_product")
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

    public Product(String name, String description, Double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

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

}
