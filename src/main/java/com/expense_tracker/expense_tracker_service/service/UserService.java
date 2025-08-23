package com.expense_tracker.expense_tracker_service.service;


import com.expense_tracker.expense_tracker_service.dto.User.UserResponseDto;
import com.expense_tracker.expense_tracker_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<UserResponseDto> getAllUser() {
        return userRepository.findAll().stream().map((data) -> UserResponseDto.builder()
                .email(data.getEmail())
                .fullName(data.getFullName())
                .build()).toList();
    }

    public UserResponseDto getByEmail(String email) {
        var userEntity = userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User is not found"));
        return UserResponseDto.builder()
                .email(userEntity.getEmail())
                .fullName(userEntity.getFullName())
                .build();
    }


}
