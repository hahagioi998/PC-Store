package com.anzurakiz.pcstorebackend.service;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.model.exceptions.CategoryNotFoundException;
import com.anzurakiz.pcstorebackend.model.exceptions.ProductNotFoundException;
import com.anzurakiz.pcstorebackend.repository.CategoryRepository;
import com.anzurakiz.pcstorebackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> save(String name) {
        return Optional.of(categoryRepository.saveAndFlush(new Category(name)));
    }

    @Override
    public Optional<Category> edit(long id, String name) {
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        category.setName(name);
        category.setRoute();

        return Optional.of(categoryRepository.save(category));
    }

    @Override
    public void deleteByName(String name) {
        categoryRepository.deleteByName(name);
    }

    @Override
    public Optional<Category> deleteById(long id) {
        return categoryRepository.deleteById(id);
    }
}
