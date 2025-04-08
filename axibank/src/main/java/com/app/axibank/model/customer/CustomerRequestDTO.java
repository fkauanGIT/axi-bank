package com.app.axibank.model.customer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
    private String name;
    private String cpf;
    private String email;
    private String telephone;
}
