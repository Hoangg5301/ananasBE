package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "PromotionEntity")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "promotionId")
    private int promotionId;

    @Column(name = "promotionName")
    private String promotionName;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private int discount;

    @OneToMany(mappedBy = "promotion")
    private Set<ProductEntity> products;
}
