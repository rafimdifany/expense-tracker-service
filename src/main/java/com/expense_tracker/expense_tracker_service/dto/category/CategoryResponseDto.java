package com.expense_tracker.expense_tracker_service.dto.category;

import com.expense_tracker.expense_tracker_service.entity.enumdata.TransactionType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private String name;
    private String code;
    private TransactionType type;
}
