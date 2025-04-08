package com.app.axibank.model.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequestDTO {
    private Long accountId;
    private Transaction.TransactionType type;
    private BigDecimal value;
    private String description;
}
