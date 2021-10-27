package com.anzurakiz.pcstorebackend.service;

import com.anzurakiz.pcstorebackend.model.Category;
import com.anzurakiz.pcstorebackend.model.Product;
import com.anzurakiz.pcstorebackend.model.ProductDto;
import com.anzurakiz.pcstorebackend.repository.CategoryRepository;
import com.anzurakiz.pcstorebackend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> save(String name, String description, double price, long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        return Optional.of(this.productRepository.save(new Product(name,
                description,
                price,
                category)));
    }

    @Override
    public Optional<Product> save(ProductDto productDto) {
        Category category = this.categoryRepository.findById(productDto.getCategory())
                .orElseThrow();

        return Optional.of(this.productRepository.save(new Product(productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                category)));
    }


    @Override
    public void delete(String name) {
        productRepository.deleteByName(name);
    }
}
