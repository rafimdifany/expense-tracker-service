package com.expense_tracker.expense_tracker_service.dto.User;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {
    private String fullName;
    private String email;
}
