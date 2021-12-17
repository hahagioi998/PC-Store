package com.anzurakiz.pcstore.service;

import com.anzurakiz.pcstore.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Optional<Product> save(String name, String description, Double price, Boolean featured, Long categoryId, Long manufacturerId, MultipartFile image);
    Optional<Product> editBy(Long id, String name, String description, Double price, Boolean featured, Long categoryId, Long manufacturerId, MultipartFile image);
    void deleteBy(Long id);

    List<Product> findAllByCategory(Long categoryId);
    List<Product> findAllByManufacturer(Long manufacturerId);
}
