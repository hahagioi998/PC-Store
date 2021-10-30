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
import java.util.stream.Collectors;

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
    public List<Product> findFeatured() {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.isFeatured())
                .limit(8)
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findAll()
                .stream()
                .filter(product -> product.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> listProductsFromCategoryWith(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException(categoryId));

        return productRepository.findAll()
                .stream()
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> findById(long id) {
        return Optional.of(productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id)));
    }

    @Override
    public Optional<Product> save(String name, String description, double price, long categoryId, String manufacturer) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();

        return Optional.of(this.productRepository.save(new Product(name,
                description,
                price,
                category,
                manufacturer)));
    }

    @Override
    public Optional<Product> edit(Product product) {
        Product productToEdit = productRepository
                .findById(product.getId())
                .orElseThrow(() -> new ProductNotFoundException(product.getId()));

        productToEdit.setQuantity(product.getQuantity());
        productToEdit.setName(product.getName());
        productToEdit.setRoute();
        productToEdit.setDescription(product.getDescription());
        productToEdit.setPrice(product.getPrice());
        productToEdit.setDiscountInPercent(product.getDiscountInPercent());
        productToEdit.setFeatured(product.isFeatured());
        productToEdit.setQuantity(product.getQuantity());
        productToEdit.setManufacturer(product.getManufacturer());

        Category category = categoryRepository.findById(product.getCategory().getId())
                .orElseThrow(() -> new CategoryNotFoundException(product.getCategory().getId()));
        productToEdit.setCategory(category);

        return Optional.of(productRepository.save(productToEdit));
    }

    @Override
    public void delete(String name) {
        productRepository.deleteByName(name);
    }
}
