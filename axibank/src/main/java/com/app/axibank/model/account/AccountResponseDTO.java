package com.app.axibank.model.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private String agency;
    private BigDecimal balance;
    private Account.AccountType accountType;
    private Long customerId;
}
