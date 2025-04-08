package com.app.axibank.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public enum TransactionType {
        CREDITO, DEBITO
    }

    private TransactionType type;

    private BigDecimal value;

    private LocalDateTime dateTransaction;

    private String description;

    @ManyToOne
    @JoinColumn(name = "transfer_id", nullable = true)
    private Transfer transfer;
}
