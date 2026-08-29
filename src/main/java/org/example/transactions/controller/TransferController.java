package org.example.transactions.controller;

import org.example.transactions.entity.TransferRecords;
import org.example.transactions.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Transfer")
public class TransferController {
    private TransferService transferService;

    public TransferController(TransferService transferService){
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody TransferRecords transaction){
        transferService.TransferMoney(transaction);
        return ResponseEntity.ok("Done");
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransferRecords> getRecord(@PathVariable Long id){
       TransferRecords t1 = transferService.getRecord(id);
       return ResponseEntity.ok(t1);
    }
}
