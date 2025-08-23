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
public class UpdateTransactionRequestDto {

    private LocalDateTime transactionDate;
    private String notes;
    private BigDecimal amount;
    private Category category;
    private String sof;
    private TransactionType type;
    private String destination; //kalau transactionType = TRANSFER

}
