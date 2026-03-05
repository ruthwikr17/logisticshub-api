package com.logistics.api.repository;

import com.logistics.api.model.Inventory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProductIdAndWarehouseId(Long productId, Long warehouseId);

    List<Inventory> findByWarehouseId(Long warehouseId);

    // Built-in support for Pagination
    Page<Inventory> findAll(Pageable pageable);
}