package com.expense_tracker.expense_tracker_service.controller;


import com.expense_tracker.expense_tracker_service.dto.AuthRequest;
import com.expense_tracker.expense_tracker_service.dto.AuthResponse;
import com.expense_tracker.expense_tracker_service.dto.RegisterRequest;
import com.expense_tracker.expense_tracker_service.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication", description = "Authentication APIs")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }


    @PostMapping("/forget-passwords")
    public ResponseEntity<String> forgetPasswords(String email) {
        return ResponseEntity.ok(authService.sendEmailForgotPassword(email));
    }
}