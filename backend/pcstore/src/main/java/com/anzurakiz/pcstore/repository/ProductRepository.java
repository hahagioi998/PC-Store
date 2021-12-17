package com.anzurakiz.pcstore.repository;

import com.anzurakiz.pcstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findProductsByCategory_Id(Long categoryId);
    List<Product> findProductsByManufacturer_Id(Long manufacturerId);
}
