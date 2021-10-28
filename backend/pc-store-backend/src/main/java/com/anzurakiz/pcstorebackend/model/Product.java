package com.anzurakiz.pcstorebackend.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

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

    @Getter
    @Setter
    private boolean featured;

    private int quantity;

    private String manufacturer;

    @ManyToOne
    private Category category;

    public Product() {
    }

    public Product(String name, String description, double price, Category category, String manufacturer) {
        this.name = name;
        this.route = name.toLowerCase().replace("\\s+", "-");
        this.description = description;
        this.price = price;
        this.discountInPercent = 0;
        this.featured = false;
        this.category = category;
        this.quantity = 0;
        this.manufacturer = manufacturer;
    }

    public void setRoute() {
        this.route = name.toLowerCase().replace("\\s+", "-");
    }
}
