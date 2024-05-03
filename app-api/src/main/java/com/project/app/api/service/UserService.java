package com.project.app.api.service;

import com.project.app.domain.user.User;
import com.project.app.infrastructure.mysql.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void join(final User user) {
        userRepository.save(user);
    }
}