package com.expense_tracker.expense_tracker_service.dto.category;

import com.expense_tracker.expense_tracker_service.entity.User;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDto {
    private String name;
    private User user;
}
