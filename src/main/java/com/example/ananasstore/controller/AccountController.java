package com.example.ananasstore.controller;

import com.example.ananasstore.dto.ResponseAPI;
import com.example.ananasstore.dto.requests.accounts.CreateAccountRequest;
import com.example.ananasstore.dto.responses.AccountDto;
import com.example.ananasstore.dto.responses.accounts.CreateAccountResponse;
import com.example.ananasstore.service.AccountService;
import com.example.ananasstore.service.impl.AccountServiceImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/account")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AccountController {

    AccountService accountService;

    //create account
    @RequestMapping(method = RequestMethod.POST, value = "/create_account")
    public ResponseAPI<CreateAccountResponse> createAccount(@RequestBody CreateAccountRequest createAccountRequest){
        CreateAccountResponse createAccountResponse = accountService.createAccount(createAccountRequest);
        return new ResponseAPI<CreateAccountResponse>(HttpStatus.OK, "create account successfully!", createAccountResponse);
    }

    //findAllAccount
    @RequestMapping(method = RequestMethod.GET, value = "/get_all_account")
    public Page<AccountDto> getAllAccount(){
        return accountService.getAllAccount(0, 10, true, "account_id");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get_account")
    public AccountDto getAccount(@RequestParam int account_id){
        return  accountService.getAccountById(account_id);
    }
}


