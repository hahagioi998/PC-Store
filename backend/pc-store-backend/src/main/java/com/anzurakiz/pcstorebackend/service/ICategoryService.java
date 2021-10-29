package com.anzurakiz.pcstorebackend.service;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.model.Product;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {

    List<Category> listCategories();

    Optional<Category> findById(long id);

    Optional<Category> save(String name);

    Optional<Category> edit(long id, String name);

    void deleteByName(String name);

    Optional<Category> deleteById(long id);
}
