package com.expense_tracker.expense_tracker_service.service;

import com.expense_tracker.expense_tracker_service.dto.category.CategoryResponseDto;
import com.expense_tracker.expense_tracker_service.entity.Category;
import com.expense_tracker.expense_tracker_service.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryResponseDto> getAll() {
        return categoryRepository.findAll().stream().map(data -> CategoryResponseDto.builder()
                .user(data.getUser())
                .name(data.getName())
                .build()).toList();
    }

    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();

        return CategoryResponseDto.builder()
                .name(category.getName())
                .user(category.getUser())
                .build();
    }
}
