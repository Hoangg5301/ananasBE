package com.example.ananasstore.common.mapper;

import com.example.ananasstore.dto.requests.accounts.CreateAccountRequest;
import com.example.ananasstore.dto.responses.accounts.CreateAccountResponse;
import com.example.ananasstore.entity.AccountEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountEntity createAccountRequestToAccountEntity(CreateAccountRequest accountRequest);
    CreateAccountResponse createAccountRequestToCreateAccountResponse(AccountEntity accountEntity);
}
