package com.ievgen.iaroshenko.usercore.controller;


import com.ievgen.iaroshenko.usercommon.CreateUserRequest;
import com.ievgen.iaroshenko.usercore.entity.User;
import com.ievgen.iaroshenko.usercore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1.0")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{id}")
    //TODO refactor exceptions
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") UUID userId) {
        User user =
                userService.findBydId(userId)
                        .orElseThrow(() -> new RuntimeException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/sign-up")
    //TODO refactor exceptions
    public UUID createUser(@RequestBody CreateUserRequest request) {
        return userService.save(request).getUuid();
    }
}
