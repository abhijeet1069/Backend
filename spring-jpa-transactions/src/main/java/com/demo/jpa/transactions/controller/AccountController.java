package com.demo.jpa.transactions.controller;

import com.demo.jpa.transactions.entity.TransferRequest;
import com.demo.jpa.transactions.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService service;

    @PostMapping("/transfer")
    public String transfer(@RequestBody TransferRequest request){

        service.transfer(request.getFromAccountId(),
                         request.getToAccountId(),
                         request.getAmount());

        return "Transfer successful";
    }
}
