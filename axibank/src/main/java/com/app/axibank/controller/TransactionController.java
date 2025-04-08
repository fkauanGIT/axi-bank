package com.app.axibank.controller;

import com.app.axibank.model.transaction.TransactionRequestDTO;
import com.app.axibank.model.transaction.TransactionResponseDTO;
import com.app.axibank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/{accountId}")
    public TransactionResponseDTO create(@PathVariable Long accountId, @RequestBody TransactionRequestDTO request) {
        return transactionService.create(accountId, request);
    }
}
