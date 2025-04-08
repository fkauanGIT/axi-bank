package com.app.axibank.model.transfer;

import com.app.axibank.model.account.Account;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_source_id", nullable = false)
    private Account accountSourceId;

    @ManyToOne
    @JoinColumn(name = "account_destination_id", nullable = false)
    private Account accountDestinationId;

    private BigDecimal value;

    private LocalDateTime dateTransference;

    private String description;

    public enum Status {
        SUCESSO, PENDENTE, FALHOU
    }

    private Status status;
}
