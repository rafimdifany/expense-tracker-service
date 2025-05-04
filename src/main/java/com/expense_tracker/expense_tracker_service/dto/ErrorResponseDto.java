package com.expense_tracker.expense_tracker_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class ErrorResponseDto {
    private String errorCode;
    private String message;
    private LocalDateTime timestamp;

}
