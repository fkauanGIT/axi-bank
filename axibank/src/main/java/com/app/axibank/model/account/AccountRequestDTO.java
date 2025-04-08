package com.app.axibank.model.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class AccountRequestDTO {
    private Long customerId;
    private Account.AccountType accountType;
}
