package com.example.ananasstore.service.impl;

import com.example.ananasstore.common.CopyProperties;
import com.example.ananasstore.common.functioninterface.ConverterEntityToDto;
import com.example.ananasstore.dto.AccountDto;
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
    public Page<AccountDto> getAllAccount(int pageNumber, int pageSize, boolean sortType, String sortField) {
        Pageable pageAccount = PageRequest.of(pageNumber, pageSize, Sort.by(sortField).descending());
        Page<AccountEntity> pageResult = accountRepository.getAllAccount(pageAccount);
        System.out.println("HoangNV");
        Page<AccountDto> accountDtoPagedtoPage = pageResult.map(new ConverterEntityToDto<AccountEntity, AccountDto>() {
            @Override
            public AccountDto apply(AccountEntity accountEntity) {
                AccountDto accountDto = new AccountDto();
                CopyProperties.copy(accountEntity, accountDto);
                return accountDto;
            }
        });
        return accountDtoPagedtoPage;
    }

    @Override
    public AccountDto getAccountById(int id) {
        AccountDto test = new AccountDto();
        CopyProperties.copy(accountRepository.getAccountById(id), test);
        return test;
    }

//    @Override
//    public void addAccount(AccountEntity accountEntity) {
//        accountRepository.saveAccount(accountEntity);
//    }
}
