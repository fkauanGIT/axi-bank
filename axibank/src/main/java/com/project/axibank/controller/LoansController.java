package com.project.axibank.controller;

import com.project.axibank.model.Loans;
import com.project.axibank.repository.LoanRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Empréstimos", description = "Consulta de empréstimos dos clientes")
public class LoansController {

    private final LoanRepository loanRepository;

    @Operation(
            summary = "Obter informações dos empréstimos",
            description = "Retorna todos os empréstimos associados ao cliente, ordenados pela data de início."
    )
    @GetMapping("/myLoans")
    @PostAuthorize("hasRole('USER')")
    public List<Loans> getLoanDetails(@RequestParam long id) {
        List<Loans> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }

}

