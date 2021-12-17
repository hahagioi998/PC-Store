package com.anzurakiz.pcstore.repository;

import com.anzurakiz.pcstore.model.ShoppingCart;
import com.anzurakiz.pcstore.model.compositeKeys.ShoppingCartId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, ShoppingCartId> {

}
