package com.project.app.api.controller.user.dto;

import com.project.app.domain.user.User;
import lombok.Getter;

@Getter
public class UserRequest {
    private String name;
    private String email;

    public User toDomain() {
        return new User(name, email);
    }
}