package com.example.ananasstore.entity;

import com.example.ananasstore.entity.key.OrderDetailKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "OrderDetail")
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailKey oderDetailId;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private OrderEntity order;

    @ManyToOne
    @MapsId("productDetailId")
    @JoinColumn(name = "productDetailId")
    private ProductEntity productDetail;

    @Column(name = "quantity")
    private int quantity;

}
