package com.project.app.api.facade;

import com.project.app.api.controller.user.dto.UserRequest;
import com.project.app.api.service.UserService;
import com.project.app.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserService userService;

    public void join(final UserRequest userRequest) {
        User user = userRequest.toDomain();
        userService.join(user);
    }
}