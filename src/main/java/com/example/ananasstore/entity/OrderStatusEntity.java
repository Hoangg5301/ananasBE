package com.example.ananasstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Table(name = "order_status")
@Getter
@Setter
@Entity
public class OrderStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id")
    private int orderStatusId;

    @Column(name = "status_name")
    private String statusName;

    @Column(name = "status_date")
    private LocalDateTime statusDate;

    //join with Order
    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<OrderEntity> orders;
}
