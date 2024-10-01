package com.example.ananasstore.controller.admin;

import com.example.ananasstore.dto.AccountDto;
import com.example.ananasstore.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/admin")
public class AccountController {
    @Autowired
    private AccountService accountService;

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


