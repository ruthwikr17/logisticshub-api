package com.logistics.api.controller;

import com.logistics.api.model.Inventory;
import com.logistics.api.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Inventory>> getAll() {
        return ResponseEntity.ok(inventoryService.getAllInventory());
    }

    @GetMapping("/paginated")
    public ResponseEntity<Page<Inventory>> getPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(inventoryService.getPaginatedInventory(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<Inventory> addStock(
            @RequestParam Long productId,
            @RequestParam Long warehouseId,
            @RequestParam Integer quantity) {
        return ResponseEntity.ok(inventoryService.addStock(productId, warehouseId, quantity));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferStock(
            @RequestParam Long productId,
            @RequestParam Long fromId,
            @RequestParam Long toId,
            @RequestParam Integer quantity) {
        inventoryService.moveStock(productId, fromId, toId, quantity);
        return ResponseEntity.ok("Transfer Successful");
    }
}