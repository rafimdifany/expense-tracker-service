package com.expense_tracker.expense_tracker_service.dto;

public record RegisterRequest(String email, String password, String fullName) {}