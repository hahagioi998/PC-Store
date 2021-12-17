package com.anzurakiz.pcstore.service.Implementation;

import com.anzurakiz.pcstore.model.Product;
import com.anzurakiz.pcstore.model.Store;
import com.anzurakiz.pcstore.model.manyToMany.ProductStore;
import com.anzurakiz.pcstore.repository.ProductRepository;
import com.anzurakiz.pcstore.repository.StoreRepository;
import com.anzurakiz.pcstore.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final ProductRepository productRepository;

    public StoreServiceImpl(StoreRepository storeRepository, ProductRepository productRepository) {
        this.storeRepository = storeRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Store> findAll() {
        return storeRepository.findAll();
    }

    @Override
    public Optional<Store> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Store save(String name) {
        return storeRepository.save(new Store(name));
    }

    @Override
    public Optional<Store> editBy(Long id, String name) {
        return Optional.empty();
    }

    @Override
    public void deleteBy(Long id) {

    }

    @Override
    public Optional<Store> addProduct(Long storeId, Long productId, Integer quantity) {
        Optional<Store> store = storeRepository.findById(storeId);
        Optional<Product> product = productRepository.findById(productId);
        if (store.isPresent() && product.isPresent())
            store.get().getProductStore().add(new ProductStore(product.get(), store.get(), quantity));
        else
            return Optional.empty();

        return Optional.of(storeRepository.save(store.get()));
    }
}
