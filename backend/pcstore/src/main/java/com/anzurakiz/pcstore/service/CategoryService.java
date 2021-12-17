package com.anzurakiz.pcstore.service;

import com.anzurakiz.pcstore.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();
    Optional<Category> findCategoryWith(Long id);
    Optional<Category> saveCategoryWith(String name);
    Optional<Category> editCategoryWith(Long id, String name);
    void deleteCategoryWith(Long id);
}
