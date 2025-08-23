package com.expense_tracker.expense_tracker_service.service;

import com.expense_tracker.expense_tracker_service.dto.transaction.TransactionRequestDto;
import com.expense_tracker.expense_tracker_service.dto.transaction.TransactionResponseDto;
import com.expense_tracker.expense_tracker_service.dto.transaction.UpdateTransactionRequestDto;
import com.expense_tracker.expense_tracker_service.entity.Transaction;
import com.expense_tracker.expense_tracker_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public List<TransactionResponseDto> getAll() {
        return transactionRepository.findAll().stream().map((result) -> TransactionResponseDto.builder()
                .type(result.getType())
                .notes(result.getNotes())
                .amount(result.getAmount())
                .category(result.getCategory())
                .transactionDate(result.getTransactionDate())
                .build()).toList();
    }

    public TransactionResponseDto findById(Long id) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow();
        return TransactionResponseDto.builder()
                .type(transaction.getType())
                .notes(transaction.getNotes())
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .transactionDate(transaction.getTransactionDate())
                .build();
    }

    //TODO: should handle transaction type TRANSFER
    public TransactionResponseDto create(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = Transaction.builder()
                .amount(transactionRequestDto.getAmount())
                .notes(transactionRequestDto.getNotes())
                .type(transactionRequestDto.getType())
                .category(transactionRequestDto.getCategory())
                .transactionDate(transactionRequestDto.getTransactionDate())
                .build();

        transactionRepository.save(transaction);


        return TransactionResponseDto.builder()
                .amount(transaction.getAmount())
                .type(transaction.getType())
                .transactionDate(transaction.getTransactionDate())
                .notes(transaction.getNotes())
                .category(transaction.getCategory())
                .build();
    }

    public TransactionResponseDto update(Long id, UpdateTransactionRequestDto transactionRequestDto) {
        Transaction transaction = transactionRepository.findById(id).orElseThrow();

        transaction.setTransactionDate(transactionRequestDto.getTransactionDate());
        transaction.setCategory(transactionRequestDto.getCategory());
        transaction.setNotes(transactionRequestDto.getNotes());
        transaction.setAmount(transactionRequestDto.getAmount());
        transaction.setType(transactionRequestDto.getType());
        //validasi transactionType, kalo type = TRANSFER -> buat mutasi baru
        transactionRepository.save(transaction);

        return TransactionResponseDto.builder()
                .transactionDate(transaction.getTransactionDate())
                .type(transaction.getType())
                .notes(transaction.getNotes())
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .transactionDate(transaction.getTransactionDate())
                .build();
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

}
