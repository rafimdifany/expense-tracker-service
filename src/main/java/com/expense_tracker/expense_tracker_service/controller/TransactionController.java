package com.expense_tracker.expense_tracker_service.controller;


import com.expense_tracker.expense_tracker_service.dto.transaction.TransactionRequestDto;
import com.expense_tracker.expense_tracker_service.dto.transaction.TransactionResponseDto;
import com.expense_tracker.expense_tracker_service.dto.transaction.UpdateTransactionRequestDto;
import com.expense_tracker.expense_tracker_service.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Transactions", description = "as it named")
public class TransactionController {

    private final TransactionService transactionService;


    @GetMapping("/transactions")
    public List<TransactionResponseDto> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/transactions/{id}")
    public TransactionResponseDto getOne(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @PostMapping("/transactions")
    public TransactionResponseDto create(@RequestBody TransactionRequestDto transactionRequestDto) {
        return transactionService.create(transactionRequestDto);
    }

    @PutMapping("/transactions/{id}")
    public TransactionResponseDto update(@PathVariable Long id, @RequestBody UpdateTransactionRequestDto transactionRequestDto) {
        return transactionService.update(id, transactionRequestDto);
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        transactionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

