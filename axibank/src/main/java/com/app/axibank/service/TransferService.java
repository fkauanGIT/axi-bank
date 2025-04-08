package com.app.axibank.service;

import com.app.axibank.model.transfer.Transfer;
import com.app.axibank.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferRepository transferRepository;

    @Transactional
    public void createTransfer(Transfer transfer) {
        transferRepository.save(transfer);
    }

    @Transactional
    public void deleteTransfer(Long id) {
        transferRepository.deleteById(id);
    }

    @Transactional
    public Transfer updateTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }
}
