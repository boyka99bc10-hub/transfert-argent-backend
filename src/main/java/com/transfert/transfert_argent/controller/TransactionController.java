package com.transfert.transfert_argent.controller;

import com.transfert.transfert_argent.model.Transaction;
import com.transfert.transfert_argent.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction enregistrerTransaction(@RequestBody Transaction transaction) {
        return transactionService.enregistrerTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }

    @DeleteMapping("/{id}")
    public void supprimerTransaction(@PathVariable Long id) {
        transactionService.supprimerTransaction(id);
    }
}
