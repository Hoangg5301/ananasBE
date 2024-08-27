package com.example.ananasstore.service;

import com.example.ananasstore.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {

    //findAll account
    Page<AccountEntity> getAllAccount(int pageNumber, int pageSize, boolean sortType, String sortField);

    //create account
    void addAccount(AccountEntity account);
}
