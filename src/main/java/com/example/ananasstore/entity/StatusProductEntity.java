package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "status_product")
public class StatusProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_product_id")
    private int statusProductId;

    @Column(name = "status_product_name")
    private String statusProductName;

    @OneToMany(mappedBy = "statusProduct")
    @JsonIgnore
    private Set<ProductDetailEntity> productDetails;
}
