package com.watcher.service;

import com.watcher.dto.user.UserRequest;

public interface UserService {
    void saveUserToDB(UserRequest userRequest);
    void notifyUser();
}
