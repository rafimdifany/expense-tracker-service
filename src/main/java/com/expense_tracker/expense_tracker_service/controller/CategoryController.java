package com.expense_tracker.expense_tracker_service.controller;

import com.expense_tracker.expense_tracker_service.dto.category.CategoryResponseDto;
import com.expense_tracker.expense_tracker_service.service.CategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Category", description = "Category Service APIs")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories() {
        return categoryService.getAll();
    }

    @GetMapping("/categories/{id}")
    public CategoryResponseDto getCategory(@PathVariable Long id) {
        return categoryService.getById(id);
    }

}
