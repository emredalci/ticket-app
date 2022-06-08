package com.ticketapp.accountservice.controller;

import com.ticketapp.accountservice.controller.endpoint.AccountEndpoint;
import com.ticketapp.accountservice.model.Account;
import com.ticketapp.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountEndpoint.ACCOUNT)
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping(AccountEndpoint.URI_GET_ACCOUNT)
    public ResponseEntity<Account> getAccount(@PathVariable String id){
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody Account account){
        return ResponseEntity.ok(accountService.saveAccount(account));
    }

    @PutMapping(AccountEndpoint.URI_UPDATE_ACCOUNT)
    public ResponseEntity<Account> updateAccount(@PathVariable String id, @RequestBody Account account){
        return ResponseEntity.ok(accountService.updateAccount(id,account));
    }
}
