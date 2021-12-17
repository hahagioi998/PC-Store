package com.anzurakiz.pcstore.model;

import com.anzurakiz.pcstore.model.compositeKeys.PurchaseSummaryId;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@IdClass(PurchaseSummaryId.class)
public class PurchaseSummary {

    @Id
    private String email;

    @Id
    @DateTimeFormat(pattern = "dd-MM-yyyy'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @OneToMany
    private List<Product> products;

    public PurchaseSummary(LocalDateTime cartOpenedTimestamp, String email) {
        this.timestamp = cartOpenedTimestamp;
        this.email = email;
    }
}
