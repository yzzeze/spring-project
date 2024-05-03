package com.project.app.infrastructure.mysql.repository.user;

import com.project.app.domain.user.User;

public interface UserRepository {

    void save(final User user);
}