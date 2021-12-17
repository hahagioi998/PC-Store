package com.anzurakiz.pcstore.service.Implementation;

import com.anzurakiz.pcstore.model.Category;
import com.anzurakiz.pcstore.model.Manufacturer;
import com.anzurakiz.pcstore.model.Product;
import com.anzurakiz.pcstore.repository.CategoryRepository;
import com.anzurakiz.pcstore.repository.ManufacturerRepository;
import com.anzurakiz.pcstore.repository.ProductRepository;
import com.anzurakiz.pcstore.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> save(String name, String description, Double price, Boolean featured, Long categoryId, Long manufacturerId, MultipartFile image) {
        Optional<Category> category = categoryRepository
                .findById(Objects.requireNonNullElse(categoryId, 1L));
        Optional<Manufacturer> manufacturer = manufacturerRepository
                .findById(Objects.requireNonNullElse(manufacturerId, 1L));

        try {
            return Optional.of(productRepository.save(new Product(
                    name,
                    description,
                    price,
                    featured,
                    category.get(),
                    manufacturer.get(),
                    image.getBytes()
            )));
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public Optional<Product> editBy(Long id, String name, String description, Double price, Boolean featured, Long categoryId, Long manufacturerId, MultipartFile image) {
        Optional<Category> category = categoryRepository
                .findById(Objects.requireNonNullElse(categoryId, 1L));
        Optional<Manufacturer> manufacturer = manufacturerRepository
                .findById(Objects.requireNonNullElse(manufacturerId, 1L));
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            product.get().setName(name);
            product.get().setDescription(description);
            product.get().setPrice(price);
            product.get().setFeatured(featured);
            product.get().setCategory(category.get());
            product.get().setManufacturer(manufacturer.get());
            try {
                product.get().setImage(image.getBytes());
            }
            catch (IOException e) {
                e.printStackTrace();
                return Optional.empty();
            }
        }
        else {
            return Optional.empty();
        }

        return Optional.of(productRepository.save(product.get()));
    }

    @Override
    public void deleteBy(Long id) {
        if(productRepository.existsById(id))
            productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByCategory(Long categoryId) {
        return productRepository.findProductsByCategory_Id(categoryId);
    }

    @Override
    public List<Product> findAllByManufacturer(Long manufacturerId) {
        return productRepository.findProductsByManufacturer_Id(manufacturerId);
    }
}
