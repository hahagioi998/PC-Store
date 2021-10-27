package com.anzurakiz.pcstorebackend.web;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
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

    @DeleteMapping("/delete")
    public ResponseEntity<Category> delete(@RequestParam long id) {
        return categoryService.deleteById(id)
                .map(category -> ResponseEntity.ok().body(category))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
