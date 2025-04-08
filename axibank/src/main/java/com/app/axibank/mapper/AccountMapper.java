package com.app.axibank.mapper;

import com.app.axibank.model.account.Account;
import com.app.axibank.model.account.AccountRequestDTO;
import com.app.axibank.model.account.AccountResponseDTO;
import com.app.axibank.model.customer.Customer;

public class AccountMapper {

    public static Account toEntity(AccountRequestDTO dto, Customer customer) {
        Account account = new Account();
        account.setCustomer(customer);
        account.setAccountType(dto.getAccountType());
        // Geração de número e agência pode ser feita aqui ou no service
        return account;
    }

    public static AccountResponseDTO toDTO(Account account) {
        AccountResponseDTO dto = new AccountResponseDTO();
        dto.setId(account.getId());
        dto.setAccountNumber(account.getAccountNumber());
        dto.setAgency(account.getAgency());
        dto.setBalance(account.getBalance());
        dto.setAccountType(account.getAccountType());
        dto.setCustomerId(account.getCustomer().getId());
        return dto;
    }
}
