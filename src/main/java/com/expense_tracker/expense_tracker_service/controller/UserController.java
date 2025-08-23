package com.expense_tracker.expense_tracker_service.controller;


import com.expense_tracker.expense_tracker_service.entity.User;
import com.expense_tracker.expense_tracker_service.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Users", description = "User Service APIs")
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public User getByEmail(String email) {
        return userService.getByEmail(email);
    }

    @GetMapping("/all-users")
    public List<User> getAll() {
        return userService.getAllUser();
    }

}
