package org.unibl.etf.is.am.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.unibl.etf.is.am.models.entities.UserEntity;
import org.unibl.etf.is.am.services.UserService;

@Configuration
public class AuditConfig {

    private final UserService userService;

    public AuditConfig(UserService userService) {
        this.userService = userService;
    }

    @Bean
    AuditorAware<UserEntity> auditorProvider() {
        return new AuditorAwareImpl(userService);
    }
}
