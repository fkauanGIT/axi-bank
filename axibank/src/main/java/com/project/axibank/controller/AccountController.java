package com.project.axibank.controller;

import com.project.axibank.model.Accounts;
import com.project.axibank.repository.AccountsRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Contas", description = "Operações relacionadas às contas bancárias")
public class AccountController {

    private final AccountsRepository accountsRepository;

    @Operation(
            summary = "Obter detalhes da conta",
            description = "Retorna os dados da conta bancária vinculada a um cliente específico, usando o ID do cliente."
    )
    @GetMapping("/myAccount")
    public Accounts getAccountDetails(@RequestParam long id) {
        Accounts accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }

}
