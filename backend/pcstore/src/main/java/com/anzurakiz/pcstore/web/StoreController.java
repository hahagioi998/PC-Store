package com.anzurakiz.pcstore.web;

import com.anzurakiz.pcstore.model.Store;
import com.anzurakiz.pcstore.service.StoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/store")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public List<Store> findAll() {
        List<Store> stores = storeService.findAll();

        return storeService.findAll();
    }

    @PostMapping
    public Store save(@RequestParam String name) {
        return storeService.save(name);
    }

    @PutMapping("/{id}/add-product")
    public ResponseEntity<Store> addProductToStore(@PathVariable Long id, @RequestParam Long productId, @RequestParam Integer quantity) {
        return storeService.addProduct(id, productId, quantity)
                .map(store -> ResponseEntity.ok().body(store))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
