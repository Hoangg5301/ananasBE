package com.example.ananasstore.entity;

import com.example.ananasstore.entity.key.OrderDetailKey;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_detail")
public class OrderDetailEntity {
    @EmbeddedId
    private OrderDetailKey oderDetailId;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @MapsId("productDetailId")
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;

    @Column(name = "quantity")
    private int quantity;

}
