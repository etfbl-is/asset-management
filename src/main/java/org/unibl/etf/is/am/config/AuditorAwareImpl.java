package org.unibl.etf.is.am.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.unibl.etf.is.am.models.dto.JwtUser;
import org.unibl.etf.is.am.models.entities.UserEntity;
import org.unibl.etf.is.am.services.UserService;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<UserEntity> {

    private final UserService userService;

    public AuditorAwareImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Optional<UserEntity> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            return Optional.of(userService.findById(jwtUser.getId(), UserEntity.class));
        }
        return Optional.empty();
    }
}
