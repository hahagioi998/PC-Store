package com.anzurakiz.pcstorebackend.model;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String route;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
        this.route = name.replaceAll("\\s+", "-").toLowerCase();
    }

    public void setRoute() {
        this.route = name.replaceAll("\\s+", "-").toLowerCase();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }
}
