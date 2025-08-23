package com.expense_tracker.expense_tracker_service.dto.transaction;

import com.expense_tracker.expense_tracker_service.entity.Category;
import com.expense_tracker.expense_tracker_service.entity.enumdata.TransactionType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto {

    private BigDecimal amount;

    private TransactionType type;

    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String notes;

    private Category category;
}
