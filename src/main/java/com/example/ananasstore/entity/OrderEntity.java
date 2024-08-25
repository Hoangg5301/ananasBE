package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    //Join with orderStatus
    @ManyToOne()
    @JoinColumn(name = "oder_status_id")
    private OrderStatusEntity orderStatus;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> orderDetails;
}
