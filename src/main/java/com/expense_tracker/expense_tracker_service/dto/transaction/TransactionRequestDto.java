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
public class TransactionRequestDto {

    private Long id;

    private BigDecimal amount;

    private String notes;

    private TransactionType type;

    private Category category;

    private String sof;

    private String dof;

    private LocalDateTime transactionDate;
}
