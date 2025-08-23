package com.expense_tracker.expense_tracker_service.repository;


import com.expense_tracker.expense_tracker_service.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
