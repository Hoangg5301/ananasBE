package com.example.ananasstore.dto;

import com.example.ananasstore.entity.CartEntity;
import com.example.ananasstore.entity.GenderEntity;
import com.example.ananasstore.entity.ProductEntity;
import com.example.ananasstore.entity.RoleEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class AccountDTO {
    private String userName;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateOfBirth;
    private GenderEntity gender;
    private RoleEntity role;
    private Set<CartEntity> carts;
    private Set<ProductEntity> products;
}
