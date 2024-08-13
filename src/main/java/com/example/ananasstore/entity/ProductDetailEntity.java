package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ProductDetailEntity")
public class ProductDetailEntity {
    @Id
    @Column(name = "productDetailId")
    private int productDetailId;

    @Column(name = "size")
    private String size;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "color")
    private String color;

    @Column(name = "img1")
    private String img1;

    @Column(name = "img2")
    private String img2;

    @Column(name = "img3")
    private String img3;

    @Column(name = "img4")
    private String img4;

    @ManyToOne
    @JoinColumn(name = "productId")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "statusProductId")
    private StatusProductEntity statusProduct;

    @OneToMany(mappedBy = "productDetail")
    private Set<OrderDetailEntity> orderDetails;

}
