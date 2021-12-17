package com.anzurakiz.pcstore.web;

import com.anzurakiz.pcstore.model.Category;
import com.anzurakiz.pcstore.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAllCategories() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryWith(@PathVariable Long id) {
        return categoryService.findCategoryWith(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategoryWith(@RequestParam String name) {
        return categoryService.saveCategoryWith(name)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Category> saveCategoryWith(@PathVariable Long id, @RequestParam String name) {
        return categoryService.editCategoryWith(id, name)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryWith(@PathVariable Long id) {
        categoryService.deleteCategoryWith(id);
    }
}
