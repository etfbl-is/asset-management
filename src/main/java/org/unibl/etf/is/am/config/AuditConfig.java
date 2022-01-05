package org.unibl.etf.is.am.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.unibl.etf.is.am.models.entities.UserEntity;
import org.unibl.etf.is.am.services.UserService;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@Profile("!database")
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
