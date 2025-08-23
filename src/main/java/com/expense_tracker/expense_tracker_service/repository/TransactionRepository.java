package com.expense_tracker.expense_tracker_service.repository;

import com.expense_tracker.expense_tracker_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
