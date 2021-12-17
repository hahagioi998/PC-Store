package com.anzurakiz.pcstore.model.compositeKeys;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class RatingId implements Serializable {

    private String email;

    private Long productId;
}
