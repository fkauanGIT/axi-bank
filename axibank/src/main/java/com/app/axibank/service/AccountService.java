package com.app.axibank.service;

import com.app.axibank.mapper.AccountMapper;
import com.app.axibank.model.account.Account;
import com.app.axibank.model.account.AccountRequestDTO;
import com.app.axibank.model.account.AccountResponseDTO;
import com.app.axibank.model.customer.Customer;
import com.app.axibank.repository.AccountRepository;
import com.app.axibank.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public AccountResponseDTO create(AccountRequestDTO request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        Account account = AccountMapper.toEntity(request, customer);
        account.setBalance(BigDecimal.ZERO); // saldo inicial
        account.setAccountNumber(generateAccountNumber());
        account.setAgency("0001"); // agência fixa ou lógica de geração

        Account saved = accountRepository.save(account);
        return AccountMapper.toDTO(saved);
    }

    public AccountResponseDTO getById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada."));
        return AccountMapper.toDTO(account);
    }

    @Transactional
    public void delete(Long id) {
        if (!accountRepository.existsById(id)) {
            throw new IllegalArgumentException("Conta não encontrada.");
        }
        accountRepository.deleteById(id);
    }

    private String generateAccountNumber() {
        // Aqui você pode usar UUID ou alguma lógica de número sequencial
        return String.valueOf((int)(Math.random() * 1_000_000_000));
    }
}
