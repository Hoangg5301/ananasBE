package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product_detail")
public class ProductDetailEntity {
    @Id
    @Column(name = "product_detail_id")
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
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "status_product_id")
    private StatusProductEntity statusProduct;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private Set<OrderDetailEntity> orderDetails;

    @OneToMany(mappedBy = "productDetail")
    @JsonIgnore
    private Set<CartEntity> carts;

}
