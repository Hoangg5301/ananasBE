package com.example.ananasstore.service.impl;

import com.example.ananasstore.common.CopyProperties;
import com.example.ananasstore.common.functioninterface.ConverterEntityToDto;
import com.example.ananasstore.common.mapper.AccountMapper;
import com.example.ananasstore.dto.requests.accounts.CreateAccountRequest;
import com.example.ananasstore.dto.responses.AccountDto;
import com.example.ananasstore.dto.responses.accounts.CreateAccountResponse;
import com.example.ananasstore.entity.AccountEntity;
import com.example.ananasstore.entity.RoleEntity;
import com.example.ananasstore.exception.AppException;
import com.example.ananasstore.exception.ErrorCode;
import com.example.ananasstore.repository.AccountRepository;
import com.example.ananasstore.repository.RoleRepository;
import com.example.ananasstore.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    RoleRepository roleRepository;
    AccountMapper accountMapper;
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public CreateAccountResponse createAccount(CreateAccountRequest request) {
        AccountEntity accountEntity = accountMapper.createAccountRequestToAccountEntity(request);
       RoleEntity role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));
       accountEntity.setRole(role);
        accountEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        accountEntity = accountRepository.save(accountEntity);
        return accountMapper.createAccountRequestToCreateAccountResponse(accountEntity);
    }

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
    public AccountDto getAccountById(Long id) {
        AccountDto test = new AccountDto();
        CopyProperties.copy(accountRepository.findById(id), test);
        return test;
    }
}
