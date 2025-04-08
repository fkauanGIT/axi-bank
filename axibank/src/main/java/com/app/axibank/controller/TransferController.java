package com.app.axibank.controller;

import com.app.axibank.model.transfer.TransferRequestDTO;
import com.app.axibank.model.transfer.TransferResponseDTO;
import com.app.axibank.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/{sourceAccountId}")
    public TransferResponseDTO transfer(@PathVariable Long sourceAccountId, @RequestBody TransferRequestDTO request) {
        return transferService.transfer(sourceAccountId, request);
    }
}
