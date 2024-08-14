package com.example.ananasstore.service.impl;

import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;
}
