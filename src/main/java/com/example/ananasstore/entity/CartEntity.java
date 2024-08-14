package com.example.ananasstore.entity;

import com.example.ananasstore.entity.key.CartKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "CartEntity")
public class CartEntity {
    @EmbeddedId
    private CartKey cartId;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "accountId")
    private AccountEntity account;

    @ManyToOne
    @MapsId("productDetailId")
    @JoinColumn(name = "productDetailId")
    private ProductDetailEntity productDetail;

    @Column(name = "quantity")
    private int quantity;
}
