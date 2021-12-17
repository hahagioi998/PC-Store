package com.anzurakiz.pcstore.model.compositeKeys;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductStorePK implements Serializable {

    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "store_id")
    private Long store_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStorePK that = (ProductStorePK) o;
        return Objects.equals(product_id, that.product_id) && Objects.equals(store_id, that.store_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product_id, store_id);
    }
}
