package com.logistics.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String sku; // Stock Keeping Unit (e.g., PROD-101)

    @Column(nullable = false)
    private String name;

    private String category;

    private Double price;

    private Integer minThreshold; // For low-stock alerts
}