package com.project.app.infrastructure.mysql.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = {"com.project.app.infrastructure.mysql.entity"})
public class JpaEntityConfig {
}