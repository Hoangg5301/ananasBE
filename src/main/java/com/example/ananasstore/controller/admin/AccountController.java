package com.example.ananasstore.controller.admin;

import com.example.ananasstore.dto.AccountDTO;
import com.example.ananasstore.entity.AccountEntity;
import com.example.ananasstore.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/admin")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //findAllAccount
    @RequestMapping(method = RequestMethod.GET, value = "/get_all_account")
    public Page<AccountEntity> getAllAccount(){
        return accountService.getAllAccount(0, 10, true, "accountId");
    }
}


