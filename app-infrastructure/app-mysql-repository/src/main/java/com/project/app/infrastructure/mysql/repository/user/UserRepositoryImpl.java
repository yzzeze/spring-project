package com.project.app.infrastructure.mysql.repository.user;

import com.project.app.domain.user.User;
import com.project.app.infrastructure.mysql.entity.UserEntity;
import com.project.app.infrastructure.mysql.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    public UserRepositoryImpl(UserJpaRepository userJpaRepository) {
        this.userJpaRepository = userJpaRepository;
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        userJpaRepository.save(userEntity);
    }
}