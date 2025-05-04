package com.expense_tracker.expense_tracker_service.controller.advice;


import com.expense_tracker.expense_tracker_service.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> handleNoSuchElement(NoSuchElementException ex) {
        ErrorResponseDto errorResponse = ErrorResponseDto.builder()
                .errorCode("404")
                .message(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralError(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("message", "General error occured", "error", ex.getMessage()));
    }
}

