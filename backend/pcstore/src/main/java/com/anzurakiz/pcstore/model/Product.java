package com.anzurakiz.pcstore.model;

import com.anzurakiz.pcstore.model.manyToMany.ProductStore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(length = 4000)
    private String description;

    private Double price;

    private Boolean featured;

    @Lob
    @Column(name = "Image", length = Integer.MAX_VALUE)
    private byte[] image;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Manufacturer manufacturer;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<ProductStore> productStore = new HashSet<>();

    public Product(String name, String description, Double price, Boolean featured, Category category, Manufacturer manufacturer, byte[] image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.featured = featured;
        this.category = category;
        this.manufacturer = manufacturer;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(price, product.price) && Objects.equals(featured, product.featured);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, featured);
    }
}
