package com.example.ananasstore.service.impl;

import com.example.ananasstore.dto.AccountDTO;
import com.example.ananasstore.entity.AccountEntity;
import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountDTO> getAllAccount(Pageable pageable, Sort sort) {
//        return accountRepository.findAllAccount(pageable, sort);
        return null;
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }
}
