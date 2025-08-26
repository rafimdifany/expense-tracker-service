package com.expense_tracker.expense_tracker_service.service;



import com.expense_tracker.expense_tracker_service.security.JwtUtil;
import com.expense_tracker.expense_tracker_service.dto.AuthRequest;
import com.expense_tracker.expense_tracker_service.dto.AuthResponse;
import com.expense_tracker.expense_tracker_service.dto.RegisterRequest;
import com.expense_tracker.expense_tracker_service.entity.User;
import com.expense_tracker.expense_tracker_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    public AuthResponse register(RegisterRequest request) {
        //Better get ke DB Caching; i.e Redis
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already in use");
        }

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .fullName(request.fullName())
                .roles(List.of("ROLE_USER"))
                .build();

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    public String sendEmailForgotPassword(String email) {
        emailService.sendHtmlMail(email, "Forgot Password");
        return "ok";
    }
}
