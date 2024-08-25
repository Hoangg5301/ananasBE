package com.example.ananasstore.service;

import com.example.ananasstore.dto.AccountDTO;
import com.example.ananasstore.entity.AccountEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IAccountService {

    //findAll account
    List<AccountDTO> getAllAccount(Pageable pageable, Sort sort);

    //create account
    void addAccount(AccountEntity account);
}
