package com.ticketapp.accountservice.service;

import com.ticketapp.accountservice.model.Account;
import com.ticketapp.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Account getAccount(String id){
        return accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public Account updateAccount(String id, Account account){
        Assert.isNull(id,"Id cannot be null");
        return accountRepository.save(account);
    }

}
