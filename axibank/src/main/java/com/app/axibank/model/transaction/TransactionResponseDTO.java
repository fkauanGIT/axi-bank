package com.app.axibank.model.transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponseDTO {
    private Long id;
    private String accountNumber;
    private Transaction.TransactionType type;
    private BigDecimal value;
    private LocalDateTime dateTransaction;
    private String description;
}
