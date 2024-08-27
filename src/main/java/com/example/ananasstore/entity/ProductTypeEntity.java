package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_type")
public class ProductTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_type_id")
    private int productTypeId;

    @Column(name = "product_type_name")
    private String productTypeName;

    @Column(name = "attribute")
    private String attribute;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @OneToMany(mappedBy = "productType")
    @JsonIgnore
    private Set<ProductEntity> products;
}
