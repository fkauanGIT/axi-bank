package com.app.axibank.service;

import com.app.axibank.model.customer.Customer;
import com.app.axibank.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Transactional
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
