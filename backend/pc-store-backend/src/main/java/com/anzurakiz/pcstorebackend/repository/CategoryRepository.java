package com.anzurakiz.pcstorebackend.repository;

import com.anzurakiz.pcstorebackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();

    Optional<Category> findById(long id);

    <S extends Category> S saveAndFlush(S entity);

    Optional<Category> deleteById(long id);

    void deleteByName(String name);
}
