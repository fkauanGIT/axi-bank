package com.app.axibank.mapper;

import com.app.axibank.model.account.Account;
import com.app.axibank.model.transaction.Transaction;
import com.app.axibank.model.transaction.TransactionRequestDTO;
import com.app.axibank.model.transaction.TransactionResponseDTO;

public class TransactionMapper {

    public static Transaction toEntity(TransactionRequestDTO dto, Account account) {
        Transaction transaction = new Transaction();
        transaction.setAccount(account);
        transaction.setType(dto.getType());
        transaction.setValue(dto.getValue());
        transaction.setDescription(dto.getDescription());
        transaction.setDateTransaction(java.time.LocalDateTime.now());
        return transaction;
    }

    public static TransactionResponseDTO toDTO(Transaction transaction) {
        TransactionResponseDTO dto = new TransactionResponseDTO();
        dto.setId(transaction.getId());
        dto.setAccountNumber(transaction.getAccount().getAccountNumber());
        dto.setType(transaction.getType());
        dto.setValue(transaction.getValue());
        dto.setDateTransaction(transaction.getDateTransaction());
        dto.setDescription(transaction.getDescription());
        return dto;
    }
}
