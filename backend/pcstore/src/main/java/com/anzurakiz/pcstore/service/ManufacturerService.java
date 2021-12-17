package com.anzurakiz.pcstore.service;

import com.anzurakiz.pcstore.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Optional<Manufacturer> findById(Long id);
    Optional<Manufacturer> save(String name);
    Optional<Manufacturer> editBy(Long id, String name);
    void deleteBy(Long id);
}
