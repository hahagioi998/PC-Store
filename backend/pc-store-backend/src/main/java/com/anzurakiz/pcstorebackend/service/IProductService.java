package com.anzurakiz.pcstorebackend.service;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> listProducts();

    void delete(String name);

    Optional<Product> save(ProductDto productDto);

    Optional<Product> save (String name, String description, double price, long categoryId);
}
