package com.expense_tracker.expense_tracker_service.dto.category;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDto {
    private Long id;
    private String name;
}
