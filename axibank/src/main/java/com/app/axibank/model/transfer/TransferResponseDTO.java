package com.app.axibank.model.transfer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferResponseDTO {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal value;
    private String description;
    private LocalDateTime dateTransference;
    private Transfer.Status status;
}
