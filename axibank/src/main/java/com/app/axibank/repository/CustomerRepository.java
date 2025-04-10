package com.app.axibank.repository;

import com.app.axibank.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByCpf(String cpf);
    Optional<Customer> findByEmail(String email);
}
