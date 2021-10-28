package com.anzurakiz.pcstorebackend.repository;

import com.anzurakiz.pcstorebackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    <S extends Product> S saveAndFlush(S entity);

    void deleteByName(String name);

    List<Product> findAll();

    Optional<Product> findById(long id);
}
