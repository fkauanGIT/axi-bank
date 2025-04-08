package com.app.axibank.service;

import com.app.axibank.mapper.TransactionMapper;
import com.app.axibank.model.account.Account;
import com.app.axibank.model.transaction.Transaction;
import com.app.axibank.model.transaction.TransactionRequestDTO;
import com.app.axibank.model.transaction.TransactionResponseDTO;
import com.app.axibank.repository.AccountRepository;
import com.app.axibank.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public TransactionResponseDTO create(Long accountId, TransactionRequestDTO request) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));

        Transaction transaction = TransactionMapper.toEntity(request, account);
        Transaction saved = transactionRepository.save(transaction);
        return TransactionMapper.toDTO(saved);
    }


}