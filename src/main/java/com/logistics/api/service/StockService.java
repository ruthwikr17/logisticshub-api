package com.logistics.api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {

    private final InventoryService inventoryService; // Injecting the other service

    @Transactional
    public void moveStock(Long productId, Long fromWarehouseId, Long toWarehouseId, Integer quantity) {
        // This coordinates the move using the InventoryService logic
        inventoryService.moveStock(productId, fromWarehouseId, toWarehouseId, quantity);
    }
}