package com.app.axibank.service;

import com.app.axibank.model.LoginRequestDTO;
import com.app.axibank.model.LoginResponseDTO;
import com.app.axibank.model.customer.Customer;
import com.app.axibank.repository.CustomerRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String jwtSecret; // Secret Key para criar o JWT

    @Value("${jwt.expiration}")
    private Long jwtExpiration; // Tempo de expiração do token (em milissegundos)

    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
        // Buscar o cliente pelo email
        Optional<Customer> customerOpt = customerRepository.findByEmail(loginRequest.email());

        if (customerOpt.isEmpty() || !passwordEncoder.matches(loginRequest.password(), customerOpt.get().getPassword())) {
            throw new RuntimeException("Credenciais inválidas.");
        }

        // Gerar o JWT se a senha for válida
        Customer customer = customerOpt.get();
        String token = generateToken(customer);

        // Retornar o nome do cliente e o token no formato DTO
        return new LoginResponseDTO(customer.getName(), token);
    }

    private String generateToken(Customer customer) {
        // Gerar o token JWT com o email do usuário como "claim"
        return Jwts.builder()
                .setSubject(customer.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }
}
