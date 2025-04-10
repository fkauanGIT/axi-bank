package com.app.axibank.service;

import com.app.axibank.mapper.CustomerMapper;
import com.app.axibank.model.customer.Customer;
import com.app.axibank.model.customer.CustomerRequestDTO;
import com.app.axibank.model.customer.CustomerResponseDTO;
import com.app.axibank.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public CustomerResponseDTO register(CustomerRequestDTO request) {
        Customer customer = CustomerMapper.toEntity(request);
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        Customer saved = customerRepository.save(customer);
        return CustomerMapper.toDTO(saved);
    }

    public CustomerResponseDTO getById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));
        return CustomerMapper.toDTO(customer);
    }

    @Transactional
    public CustomerResponseDTO update(Long id, CustomerRequestDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado."));

        customer.setName(request.getName());
        customer.setCpf(request.getCpf());
        customer.setEmail(request.getEmail());
        customer.setTelephone(request.getTelephone());

        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            customer.setPassword(passwordEncoder.encode(request.getPassword()));
        }

        Customer updated = customerRepository.save(customer);
        return CustomerMapper.toDTO(updated);
    }

    @Transactional
    public void delete(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
        customerRepository.deleteById(id);
    }
}
