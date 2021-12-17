package com.anzurakiz.pcstore.service.Implementation;

import com.anzurakiz.pcstore.model.Category;
import com.anzurakiz.pcstore.model.Manufacturer;
import com.anzurakiz.pcstore.repository.ManufacturerRepository;
import com.anzurakiz.pcstore.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;

        if (manufacturerRepository.findAll().size() == 0)
            manufacturerRepository.save(new Manufacturer("Unknown"));
    }

    @Override
    public List<Manufacturer> findAll() {
        return manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return manufacturerRepository.findById(id);
    }

    @Override
    public Optional<Manufacturer> save(String name) {
        return Optional.of(manufacturerRepository.save(new Manufacturer(name)));
    }

    @Override
    public Optional<Manufacturer> editBy(Long id, String name) {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        if (manufacturer.isPresent())
            manufacturer.get().setName(name);
        else
            return Optional.empty();

        return Optional.of(manufacturerRepository.save(manufacturer.get()));
    }

    @Override
    public void deleteBy(Long id) {
        if (manufacturerRepository.existsById(id))
            manufacturerRepository.deleteById(id);
    }
}
