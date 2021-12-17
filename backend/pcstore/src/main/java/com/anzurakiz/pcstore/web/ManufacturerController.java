package com.anzurakiz.pcstore.web;

import com.anzurakiz.pcstore.model.Manufacturer;
import com.anzurakiz.pcstore.service.ManufacturerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/manufacturer")
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public List<Manufacturer> findAll() {
        return manufacturerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> findBy(@PathVariable Long id) {
        return manufacturerService.findById(id)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/save")
    public ResponseEntity<Manufacturer> save(@RequestParam String name) {
        return manufacturerService.save(name)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Manufacturer> editBy(@PathVariable Long id, @RequestParam String name) {
        return manufacturerService.editBy(id, name)
                .map(manufacturer -> ResponseEntity.ok().body(manufacturer))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBy(@PathVariable Long id) {
        manufacturerService.deleteBy(id);
    }
}
