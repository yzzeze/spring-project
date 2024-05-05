package com.project.app.infrastructure.mysql.repository.user;

import com.project.app.infrastructure.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {
}