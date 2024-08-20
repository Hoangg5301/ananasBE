package com.example.ananasstore.entity;

import com.example.ananasstore.entity.key.CartKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart_entity")
public class CartEntity {
    @EmbeddedId
    private CartKey cartId;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private AccountEntity account;

    @ManyToOne
    @MapsId("productDetailId")
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;

    @Column(name = "quantity")
    private int quantity;
}
