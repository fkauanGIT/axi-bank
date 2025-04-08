package com.app.axibank.service;

import com.app.axibank.mapper.TransactionMapper;
import com.app.axibank.mapper.TransferMapper;
import com.app.axibank.model.account.Account;
import com.app.axibank.model.transaction.Transaction;
import com.app.axibank.model.transfer.Transfer;
import com.app.axibank.model.transfer.TransferRequestDTO;
import com.app.axibank.model.transfer.TransferResponseDTO;
import com.app.axibank.repository.AccountRepository;
import com.app.axibank.repository.TransactionRepository;
import com.app.axibank.repository.TransferRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;
    private final TransactionRepository transactionRepository;

    @Transactional
    public TransferResponseDTO transfer(Long sourceAccountId, TransferRequestDTO request) {
        Account source = accountRepository.findById(sourceAccountId)
                .orElseThrow(() -> new IllegalArgumentException("Conta de origem não encontrada."));

        Account destination = accountRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new IllegalArgumentException("Conta de destino não encontrada."));

        BigDecimal value = request.getValue();
        if (source.getBalance().compareTo(value) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }

        // Criação da entidade Transfer
        Transfer transfer = new Transfer();
        transfer.setAccountSource(source);
        transfer.setAccountDestination(destination);
        transfer.setValue(value);
        transfer.setDescription(request.getDescription());
        transfer.setDateTransference(LocalDateTime.now());
        transfer.setStatus(Transfer.Status.SUCESSO);

        // Débito na origem
        Transaction debit = new Transaction();
        debit.setAccount(source);
        debit.setType(Transaction.TransactionType.DEBITO);
        debit.setValue(value);
        debit.setDescription("Transferência para conta " + destination.getAccountNumber());
        debit.setDateTransaction(LocalDateTime.now());
        debit.setTransfer(transfer);

        // Crédito no destino
        Transaction credit = new Transaction();
        credit.setAccount(destination);
        credit.setType(Transaction.TransactionType.CREDITO);
        credit.setValue(value);
        credit.setDescription("Transferência recebida da conta " + source.getAccountNumber());
        credit.setDateTransaction(LocalDateTime.now());
        credit.setTransfer(transfer);

        // Atualiza saldos
        source.setBalance(source.getBalance().subtract(value));
        destination.setBalance(destination.getBalance().add(value));

        // Salva tudo
        transferRepository.save(transfer);
        transactionRepository.save(debit);
        transactionRepository.save(credit);
        accountRepository.save(source);
        accountRepository.save(destination);

        return TransferMapper.toDTO(transfer);
    }
}
