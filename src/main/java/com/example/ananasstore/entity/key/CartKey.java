package com.example.ananasstore.entity.key;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class CartKey {
    private int accountId;

    private int productDetailId;
}
