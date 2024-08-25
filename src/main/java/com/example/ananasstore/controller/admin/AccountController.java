package com.example.ananasstore.controller.admin;

import com.example.ananasstore.dto.AccountDTO;
import com.example.ananasstore.service.impl.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    //findAllAccount
    @RequestMapping(method = RequestMethod.GET, value = "/allaccount")
    public List<AccountDTO> getAllAccount(){
//        List<AccountDTO>
        return null;
    }
}


