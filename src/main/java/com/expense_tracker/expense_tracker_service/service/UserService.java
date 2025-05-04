package com.expense_tracker.expense_tracker_service.service;


import com.expense_tracker.expense_tracker_service.entity.User;
import com.expense_tracker.expense_tracker_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public User getByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new NoSuchElementException("User is not found"));
    }


}
