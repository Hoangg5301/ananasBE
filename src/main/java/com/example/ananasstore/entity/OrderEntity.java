package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private int orderId;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    //Join with orderStatus
    @ManyToOne()
    @JoinColumn(name = "oderStatusId")
    private OrderStatusEntity orderStatus;

    @OneToMany(mappedBy = "order")
    private Set<OrderDetailEntity> orderDetails;
}
