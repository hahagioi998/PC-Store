package com.anzurakiz.pcstorebackend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
}
