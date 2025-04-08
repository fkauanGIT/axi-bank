package com.app.axibank.mapper;

import com.app.axibank.model.account.Account;
import com.app.axibank.model.transfer.Transfer;
import com.app.axibank.model.transfer.TransferRequestDTO;
import com.app.axibank.model.transfer.TransferResponseDTO;

import java.time.LocalDateTime;

public class TransferMapper {

    public static Transfer toEntity(TransferRequestDTO dto, Account sourceAccount, Account destinationAccount) {
        Transfer transfer = new Transfer();
        transfer.setAccountSource(sourceAccount);
        transfer.setAccountDestination(destinationAccount);
        transfer.setValue(dto.getValue());
        transfer.setDescription(dto.getDescription());
        transfer.setDateTransference(LocalDateTime.now());
        transfer.setStatus(Transfer.Status.PENDENTE); // ou SUCESSO/FALHOU dependendo da lógica de negócio
        return transfer;
    }

    public static TransferResponseDTO toDTO(Transfer transfer) {
        TransferResponseDTO dto = new TransferResponseDTO();
        dto.setSourceAccountNumber(transfer.getAccountSource().getAccountNumber());
        dto.setDestinationAccountNumber(transfer.getAccountDestination().getAccountNumber());
        dto.setValue(transfer.getValue());
        dto.setDescription(transfer.getDescription());
        dto.setDateTransference(transfer.getDateTransference());
        dto.setStatus(transfer.getStatus());
        return dto;
    }
}
