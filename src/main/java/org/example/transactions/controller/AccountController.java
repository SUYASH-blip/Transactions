package org.example.transactions.controller;

import org.example.transactions.entity.Account;
import org.example.transactions.repository.AccountRepository;
import org.example.transactions.repository.TransferRepository;
import org.example.transactions.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Accounts")
public class AccountController {
    private AccountRepository accountRepository;
    private TransferService transferService;

    public AccountController(AccountRepository accountRepository, TransferService transferService){
        this.accountRepository= accountRepository;
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Account account){
        accountRepository.save(account);
        return ResponseEntity.ok("Created");
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
      Account account = transferService.getAccount(id);
      return ResponseEntity.ok(account);
    }

}
