package com.example.ananasstore.service;

import com.example.ananasstore.dto.responses.AccountDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {

    //findAll account
    Page<AccountDto> getAllAccount(int pageNumber, int pageSize, boolean sortType, String sortField);

    //find account
    AccountDto getAccountById(int id);

    //create account
//    void addAccount(AccountEntity account);
}
