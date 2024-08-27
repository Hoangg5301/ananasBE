package com.example.ananasstore.entity;

import com.example.ananasstore.entity.key.CartKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class CartEntity {
    @EmbeddedId
    private CartKey cartId;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private AccountEntity account;

    @ManyToOne
    @JsonIgnore
    @MapsId("productDetailId")
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;

    @Column(name = "quantity")
    private int quantity;
}
