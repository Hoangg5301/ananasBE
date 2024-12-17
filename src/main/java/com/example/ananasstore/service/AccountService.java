package com.example.ananasstore.service;

import com.example.ananasstore.dto.requests.accounts.CreateAccountRequest;
import com.example.ananasstore.dto.responses.AccountDto;
import com.example.ananasstore.dto.responses.accounts.CreateAccountResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    //create Account
    CreateAccountResponse createAccount(CreateAccountRequest request);

    //findAll account
    Page<AccountDto> getAllAccount(int pageNumber, int pageSize, boolean sortType, String sortField);

    //find account
    AccountDto getAccountById(int id);

}
