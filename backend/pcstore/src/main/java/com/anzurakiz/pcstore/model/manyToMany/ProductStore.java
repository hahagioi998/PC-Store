package com.anzurakiz.pcstore.model.manyToMany;

import com.anzurakiz.pcstore.model.Product;
import com.anzurakiz.pcstore.model.Store;
import com.anzurakiz.pcstore.model.compositeKeys.ProductStorePK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_store")
public class ProductStore implements Serializable {

    @EmbeddedId
    private ProductStorePK id;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @MapsId("store_id")
    @JoinColumn(name = "store_id")
    @JsonIgnore
    private Store store;

    private Integer productQuantity;

    public ProductStore(Product product, Store store, Integer productQuantity) {
        this.id = new ProductStorePK(product.getId(), store.getId());
        this.product = product;
        this.store = store;
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductStore that = (ProductStore) o;
        return Objects.equals(product, that.product) && Objects.equals(store, that.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, store);
    }
}
