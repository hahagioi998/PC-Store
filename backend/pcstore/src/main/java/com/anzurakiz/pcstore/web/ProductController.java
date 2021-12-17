package com.anzurakiz.pcstore.web;

import com.anzurakiz.pcstore.model.Product;
import com.anzurakiz.pcstore.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAll(@RequestParam(required = false) Long categoryId,
                                 @RequestParam(required = false) Long manufacturerId) {

        if(categoryId != null)
            return productService.findAllByCategory(categoryId);
        else if(manufacturerId != null)
            return productService.findAllByManufacturer(manufacturerId);

        return productService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findCategoryWith(@PathVariable Long id) {
        return productService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Product> saveCategoryWith(@RequestParam String name,
                                                    @RequestParam String description,
                                                    @RequestParam Double price,
                                                    @RequestParam Boolean featured,
                                                    @RequestParam(required = false) Long categoryId,
                                                    @RequestParam(required = false) Long manufacturerId,
                                                    @RequestParam(required = false) MultipartFile image) {

        return productService.save(name, description, price, featured, categoryId, manufacturerId, image)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Product> saveCategoryWith(@PathVariable Long id,
                                                    @RequestParam String name,
                                                    @RequestParam String description,
                                                    @RequestParam Double price,
                                                    @RequestParam Boolean featured,
                                                    @RequestParam(required = false) Long categoryId,
                                                    @RequestParam(required = false) Long manufacturerId,
                                                    @RequestParam(required = false) MultipartFile image){

        return productService.editBy(id, name, description, price, featured, categoryId, manufacturerId, image)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBy(@PathVariable Long id) {
        productService.deleteBy(id);
    }
}
