package com.app.axibank.mapper;

import com.app.axibank.model.customer.Customer;
import com.app.axibank.model.customer.CustomerRequestDTO;
import com.app.axibank.model.customer.CustomerResponseDTO;

public class CustomerMapper {

    public static Customer toEntity(CustomerRequestDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setCpf(dto.getCpf());
        customer.setEmail(dto.getEmail());
        customer.setPassword(dto.getPassword());
        customer.setTelephone(dto.getTelephone());
        return customer;
    }

    public static CustomerResponseDTO toDTO(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setName(customer.getName());
        dto.setCpf(customer.getCpf());
        dto.setEmail(customer.getEmail());
        dto.setPassword(customer.getPassword());
        dto.setTelephone(customer.getTelephone());
        dto.setCustomerType(customer.getCustomerType());
        return dto;
    }
}
