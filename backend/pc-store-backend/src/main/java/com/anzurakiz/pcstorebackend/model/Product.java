package com.anzurakiz.pcstorebackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String route;

    private String description;

    private double price;

    private int discountInPercent;

    private boolean isFeatured;

    private int quantity;

    @ManyToOne
    private Category category;

    public Product(String name, String description, double price, Category category) {
        this.name = name;
        this.route = name.toLowerCase().replace("\\s+", "-");
        this.description = description;
        this.price = price;
        this.discountInPercent = 0;
        this.isFeatured = false;
        this.category = category;
        this.quantity = 0;
    }
}
