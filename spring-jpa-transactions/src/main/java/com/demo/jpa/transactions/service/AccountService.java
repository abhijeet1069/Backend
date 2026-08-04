package com.demo.jpa.transactions.service;

import com.demo.jpa.transactions.entity.Account;
import com.demo.jpa.transactions.respository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount){
        Account from = repository.findById(fromId).orElseThrow();
        Account to = repository.findById(toId).orElseThrow();

        if(from.getBalance().compareTo(amount) < 0)
            throw new RuntimeException("Insufficient balance");

        from.setBalance(from.getBalance().subtract(amount));
        to.setBalance(to.getBalance().add(amount));

        repository.save(from);
        repository.save(to);
    }
}
