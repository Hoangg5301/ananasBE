package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "StatusProduct")
public class StatusProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusProductId")
    private int statusProductId;

    @Column(name = "statusProductName")
    private String statusProductName;

    @OneToMany(mappedBy = "statusProduct")
    private Set<ProductDetailEntity> productDetails;
}
