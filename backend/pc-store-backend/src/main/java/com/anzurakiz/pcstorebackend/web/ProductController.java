package com.anzurakiz.pcstorebackend.web;

import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.model.ProductDto;
import com.anzurakiz.pcstorebackend.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
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

//    @PostMapping("/add")
//    public ResponseEntity<Product> save(@RequestBody ProductDto productDto) {
//        Product p = this.productService.save(productDto);
//
//        return ResponseEntity.ok(p);
//    }

}
