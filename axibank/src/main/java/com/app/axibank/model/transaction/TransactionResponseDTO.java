package com.app.axibank.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionResponseDTO {
    private Long id;
    private String accountNumber;
    private Transaction.TransactionType type;
    private BigDecimal value;
    private LocalDateTime dateTransaction;
    private String description;
}
