package com.anzurakiz.pcstore.service.Implementation;

import com.anzurakiz.pcstore.model.Category;
import com.anzurakiz.pcstore.repository.CategoryRepository;
import com.anzurakiz.pcstore.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;

        if (categoryRepository.findAll().size() == 0)
            categoryRepository.save(new Category("Unknown"));
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryWith(Long id) {
        return categoryRepository.findCategoryById(id);
    }

    @Override
    public Optional<Category> saveCategoryWith(String name) {
        return Optional.of(categoryRepository.save(new Category(name)));
    }

    @Override
    public Optional<Category> editCategoryWith(Long id, String name) {
        Optional<Category> category = categoryRepository.findCategoryById(id);
        if (category.isPresent())
            category.get().setName(name);
        else
            return Optional.empty();

        return Optional.of(categoryRepository.save(category.get()));

    }

    @Override
    public void deleteCategoryWith(Long id) {
        if (categoryRepository.existsById(id))
            categoryRepository.deleteById(id);
    }


}
