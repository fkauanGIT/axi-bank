package com.app.axibank.model.account;

import java.math.BigDecimal;

public class AccountResponseDTO {
    private Long id;
    private String accountNumber;
    private String agency;
    private BigDecimal balance;
    private Account.AccountType accountType;
}
