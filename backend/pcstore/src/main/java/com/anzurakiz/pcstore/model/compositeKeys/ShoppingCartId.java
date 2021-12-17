package com.anzurakiz.pcstore.model.compositeKeys;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
public class ShoppingCartId implements Serializable {
    private String email;

    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime timestamp;


}
