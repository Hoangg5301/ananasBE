package com.example.ananasstore.dto;

import com.example.ananasstore.entity.GenderEntity;
import com.example.ananasstore.entity.RoleEntity;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AccountDto {
    private int accountId;
    private String userName;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDateTime dateOfBirth;
    private GenderEntity gender;
    private RoleEntity role;
}
