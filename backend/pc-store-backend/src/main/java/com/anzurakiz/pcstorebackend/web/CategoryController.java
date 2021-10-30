package com.anzurakiz.pcstorebackend.web;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.service.CategoryService;
import com.anzurakiz.pcstorebackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping
    private List<Category> findAll() {
        return categoryService.listCategories();
    }

    @PostMapping("/add")
    public ResponseEntity<Category> create(@RequestBody Map<String, String> body) {
        return categoryService.save(body.get("name"))
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{categoryId}")
    public List<Product> findAllFromCategoryWithId(@PathVariable long categoryId) {
        return this.productService.listProductsFromCategoryWith(categoryId);
    }

    @DeleteMapping("{categoryId}/delete")
    public ResponseEntity<Category> delete(@PathVariable long categoryId) {
        return categoryService.deleteById(categoryId)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("{categoryId}/edit")
    public ResponseEntity<Category> edit(@PathVariable long categoryId, @RequestParam String name) {
        return categoryService.edit(categoryId, name)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
