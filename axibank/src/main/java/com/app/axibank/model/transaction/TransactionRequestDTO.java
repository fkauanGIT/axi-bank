package com.app.axibank.model.transaction;

import java.math.BigDecimal;

public class TransactionRequestDTO {
    private Long accountId;
    private Transaction.TransactionType type;
    private BigDecimal value;
    private String description;
}
