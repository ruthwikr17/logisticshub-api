package com.logistics.api.service;

import com.logistics.api.model.Inventory;
import com.logistics.api.repository.InventoryRepository;
import com.logistics.api.repository.ProductRepository;
import com.logistics.api.repository.WarehouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final WarehouseRepository warehouseRepository;

    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    public Page<Inventory> getPaginatedInventory(int page, int size) {
        return inventoryRepository.findAll(PageRequest.of(page, size));
    }

    public List<Inventory> getInventoryByWarehouse(Long warehouseId) {
        return inventoryRepository.findByWarehouseId(warehouseId);
    }

    @Transactional
    public Inventory addStock(Long productId, Long warehouseId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductIdAndWarehouseId(productId, warehouseId)
                .orElse(new Inventory());

        if (inventory.getId() == null) {
            inventory.setProduct(productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found")));
            inventory.setWarehouse(warehouseRepository.findById(warehouseId)
                    .orElseThrow(() -> new RuntimeException("Warehouse not found")));
            inventory.setQuantity(0);
        }

        inventory.setQuantity(inventory.getQuantity() + quantity);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public void moveStock(Long productId, Long fromWarehouseId, Long toWarehouseId, Integer quantity) {
        Inventory source = inventoryRepository.findByProductIdAndWarehouseId(productId, fromWarehouseId)
                .orElseThrow(() -> new RuntimeException("Source inventory not found"));

        if (source.getQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock in source warehouse");
        }

        source.setQuantity(source.getQuantity() - quantity);
        inventoryRepository.save(source);

        addStock(productId, toWarehouseId, quantity);
    }
}