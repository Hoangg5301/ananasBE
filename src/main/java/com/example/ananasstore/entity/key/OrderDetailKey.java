package com.example.ananasstore.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderDetailKey {

    @Column(name = "orderId")
    private int oderId;

    @Column(name = "productDetailId")
    private int productDetailId;
}
