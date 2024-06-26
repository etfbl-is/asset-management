package org.unibl.etf.is.am.services.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.exceptions.UnauthorizedException;
import org.unibl.etf.is.am.models.dto.JwtUser;
import org.unibl.etf.is.am.models.dto.LoginResponse;
import org.unibl.etf.is.am.models.requests.LoginRequest;
import org.unibl.etf.is.am.services.AuthService;
import org.unibl.etf.is.am.services.UserService;
import org.unibl.etf.is.am.util.LoggingUtil;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    @Value("${authorization.token.expiration-time}")
    private String tokenExpirationTime;
    @Value("${authorization.token.secret}")
    private String tokenSecret;


    public AuthServiceImpl(AuthenticationManager authenticationManager, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response;
        try {
            Authentication authenticate = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );
            JwtUser user = (JwtUser) authenticate.getPrincipal();
            response = userService.findById(user.getId(), LoginResponse.class);
            response.setToken(generateJwt(user));
        } catch (Exception ex) {
            LoggingUtil.logException(ex, getClass());
            throw new UnauthorizedException();
        }
        return response;
    }

    private String generateJwt(JwtUser user) {
        return Jwts.builder()
                .id(user.getId().toString())
                .claim("role", user.getRole().name())
                .subject(user.getId().toString())
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(tokenExpirationTime)))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenSecret)))
                .compact();
    }
}
