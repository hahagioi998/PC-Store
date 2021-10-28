package com.anzurakiz.pcstorebackend.service;

import com.anzurakiz.pcstorebackend.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> listProducts();

    List<Product> listProductsFromCategoryWith(long categoryId);

    Optional<Product> findById(long id);

    void delete(String name);

    Optional<Product> save (String name, String description, double price, long categoryId, String manufacturer);

    Optional<Product> edit (Product product);
}
