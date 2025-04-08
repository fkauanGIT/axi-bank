package com.app.axibank.controller;

import com.app.axibank.model.account.AccountRequestDTO;
import com.app.axibank.model.account.AccountResponseDTO;
import com.app.axibank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public AccountResponseDTO create(@RequestBody AccountRequestDTO request) {
        return accountService.create(request);
    }

    @GetMapping("/{id}")
    public AccountResponseDTO getById(@PathVariable Long id) {
        return accountService.getById(id);
    }
}
