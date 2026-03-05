package com.logistics.api.controller;

import com.logistics.api.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping("/transfer")
    public ResponseEntity<String> transferStock(
            @RequestParam Long productId,
            @RequestParam Long fromWarehouseId,
            @RequestParam Long toWarehouseId,
            @RequestParam Integer quantity) {
        stockService.moveStock(productId, fromWarehouseId, toWarehouseId, quantity);
        return ResponseEntity.ok("Stock transfer completed via StockService");
    }
}