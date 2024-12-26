package com.example.ananasstore.entity.key;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class OrderDetailKey {

    private Long orderId;

    private Long productDetailId;
}
