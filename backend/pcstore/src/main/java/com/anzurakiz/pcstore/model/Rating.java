package com.anzurakiz.pcstore.model;

import com.anzurakiz.pcstore.model.compositeKeys.RatingId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@IdClass(RatingId.class)
public class Rating {

    @Id
    private String email;

    @Id
    private Long productId;

    private Integer rating;

    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @Column(length = 1000)
    private String comment;

    public Rating(String email, Integer rating, LocalDateTime timestamp, Long productId, String comment) {
        this.rating = rating;
        this.timestamp = timestamp;
        this.comment = comment;
        this.email = email;
        this.productId = productId;
    }
}
