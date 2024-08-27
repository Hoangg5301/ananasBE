package com.example.ananasstore.service.impl;

import com.example.ananasstore.entity.AccountEntity;
import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Page<AccountEntity> getAllAccount(int pageNumber, int pageSize, boolean sortType, String sortField) {
        Pageable pageAccount = PageRequest.of(pageNumber, pageSize, Sort.by(sortField).descending());
        Page<AccountEntity> pageResult = accountRepository.getAllAccount(pageAccount);
        System.out.println("temp");
        return pageResult;
    }

    @Override
    public void addAccount(AccountEntity accountEntity) {
        accountRepository.save(accountEntity);
    }
}
