package org.example.transactions.service;

import jakarta.transaction.Transactional;
import org.example.transactions.entity.Account;
import org.example.transactions.entity.TransferRecords;
import org.example.transactions.repository.AccountRepository;
import org.example.transactions.repository.TransferRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository,
                           TransferRepository transferRepository){
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }


    @Transactional
    public void TransferMoney(TransferRecords transferRecords){

        Account FromAccount = accountRepository.findById(transferRecords.getFromAccountId()).
                orElseThrow(() ->new RuntimeException("ACCOUNT NOT FOUND"));

        Account ToAccount = accountRepository.findById(transferRecords.getToAccountId()).
                orElseThrow(() ->new RuntimeException("ACCOUNT NOT FOUND"));

        FromAccount.DebitAccount(transferRecords.getAmount());
        ToAccount.CreditAccount(transferRecords.getAmount());
         transferRecords.setTransferredAt(LocalDate.now());
        transferRepository.save(transferRecords);
    }

    @Transactional
    public Account getAccount(Long id){
        return accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not Found"));
    }
    @Transactional
    public TransferRecords getRecord(Long id){
        return transferRepository.findById(id).orElseThrow(()->new RuntimeException("Record Not Found"));
    }
}
