package com.app.axibank.model.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponseDTO {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private BigDecimal value;
    private String description;
    private LocalDateTime dateTransference;
    private Transfer.Status status;
}
