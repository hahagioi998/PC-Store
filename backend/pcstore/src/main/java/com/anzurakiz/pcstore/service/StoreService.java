package com.anzurakiz.pcstore.service;

import com.anzurakiz.pcstore.model.Manufacturer;
import com.anzurakiz.pcstore.model.Store;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StoreService {
    List<Store> findAll();
    Optional<Store> findById(Long id);
    Store save(String name);
    Optional<Store> editBy(Long id, String name);
    void deleteBy(Long id);

    Optional<Store> addProduct(Long storeId, Long productId, Integer quantity);
}
