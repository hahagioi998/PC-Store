package com.anzurakiz.pcstorebackend.web;

import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    private List<Product> findAll() {
        return productService.listProducts();
    }

    @GetMapping("/featured")
    private List<Product> findFeatured() {
        return productService.findFeatured();
    }

    @GetMapping("/search")
    private List<Product> findByName(@RequestParam String params) {
        return productService.findByName(params);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> save(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        String description = body.get("description");
        double price = Double.parseDouble(body.get("price"));
        long category = Long.parseLong(body.get("category"));
        String manufacturer = body.get("manufacturer");

        return this.productService.save(name, description, price, category, manufacturer)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return this.productService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    //long id, String name, String description, double price, long categoryId, int discountInPercent, boolean isFeatured, int quantity
    @PutMapping("{productId}/edit")
    public ResponseEntity<Product> setQuantity(@PathVariable long productId, @RequestBody Product productToEdit) {
        return this.productService.edit(productToEdit)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }


}
