package com.example.ananasstore.dto.responses.accounts;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountResponse {
    private String userName;
    private String password;
    private String email;
    private String address;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
