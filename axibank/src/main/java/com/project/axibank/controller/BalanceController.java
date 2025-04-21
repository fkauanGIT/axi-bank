package com.project.axibank.controller;

import com.project.axibank.model.AccountTransactions;
import com.project.axibank.repository.AccountTransactionsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Saldo", description = "Consulta de transações e histórico do cliente")
public class BalanceController {

    private final AccountTransactionsRepository accountTransactionsRepository;

    @Operation(
            summary = "Obter extrato bancário",
            description = "Retorna o histórico de transações de um cliente com base no ID fornecido, em ordem decrescente de data."
    )
    @GetMapping("/myBalance")
    public List<AccountTransactions> getBalanceDetails(@RequestParam long id) {
        List<AccountTransactions> accountTransactions = accountTransactionsRepository.
                findByCustomerIdOrderByTransactionDtDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
