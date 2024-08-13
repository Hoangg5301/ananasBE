package com.example.ananasstore.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "OrderStatus")
@Getter
@Setter
@Entity
public class OrderStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderStatusId")
    private int orderStatusId;

    @Column(name = "statusName")
    private String statusName;

    @Column(name = "statusDate")
    private LocalDateTime statusDate;

    //join with Order
    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderEntity> orders;
}
