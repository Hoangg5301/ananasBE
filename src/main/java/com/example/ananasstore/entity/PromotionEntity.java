package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "promotion")
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private int promotionId;

    @Column(name = "promotion_name")
    private String promotionName;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private int discount;

    @OneToMany(mappedBy = "promotion")
    @JsonIgnore
    private Set<ProductEntity> products;
}
