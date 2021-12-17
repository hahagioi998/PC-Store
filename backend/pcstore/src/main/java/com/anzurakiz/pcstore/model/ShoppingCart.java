package com.anzurakiz.pcstore.model;

import com.anzurakiz.pcstore.model.compositeKeys.ShoppingCartId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@IdClass(ShoppingCartId.class)
public class ShoppingCart {

    @Id
    private String email;

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @ManyToMany
    private List<Product> products;

    public ShoppingCart(LocalDateTime cartOpenedTimestamp, String email) {
        this.timestamp = cartOpenedTimestamp;
        this.email = email;
    }
}
