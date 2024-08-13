package com.example.ananasstore.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CartKey {
    @Column(name = "accountId")
    private int accountId;

    @Column(name = "productDetailId")
    private int productDetailId;
}
