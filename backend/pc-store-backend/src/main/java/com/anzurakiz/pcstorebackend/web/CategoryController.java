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
//@CrossOrigin(origins = "http://localhost:3000")
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

    @DeleteMapping("/delete")
    public ResponseEntity<Category> delete(@RequestParam long id) {
        return categoryService.deleteById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
