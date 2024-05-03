package com.project.app.api.controller.user;

import com.project.app.api.controller.user.dto.UserRequest;
import com.project.app.api.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/join")
    public ResponseEntity join(
          @RequestBody final UserRequest userRequest
    ) {
        userFacade.join(userRequest);
        return ResponseEntity.ok().build();
    }
}
