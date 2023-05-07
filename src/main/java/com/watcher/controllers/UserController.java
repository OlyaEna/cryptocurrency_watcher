package com.watcher.controllers;

import com.watcher.dto.user.UserRequest;
import com.watcher.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    /**
     * Регистрация пользователя
     */

    @PostMapping("/notify")
    public void saveUserToDB(@RequestBody UserRequest userRequest) {
        userService.saveUserToDB(userRequest);
    }
}
