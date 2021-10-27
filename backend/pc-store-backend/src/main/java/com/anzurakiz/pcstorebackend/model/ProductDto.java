package com.anzurakiz.pcstorebackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
public class ProductDto {

    private String name;

    private String description;

    private double price;

    private long category;

    public ProductDto(String name, String description, double price, long category) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }
}
