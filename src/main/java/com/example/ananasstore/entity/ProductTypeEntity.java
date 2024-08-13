package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ProductType")
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productTypeId")
    private int productTypeId;

    @Column(name = "productTypeName")
    private String productTypeName;

    @Column(name = "attribute")
    private String attribute;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private CategoryEntity category;

    @OneToMany(mappedBy = "productType")
    private Set<ProductEntity> products;
}
