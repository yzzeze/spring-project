package com.project.app.infrastructure.mysql.mapper;

import com.project.app.domain.user.User;
import com.project.app.infrastructure.mysql.entity.UserEntity;

public class UserMapper {

    public UserMapper() {
    }

    public static UserEntity toEntity(final User user) {
        return new UserEntity(user.getName(), user.getEmail());
    }
}