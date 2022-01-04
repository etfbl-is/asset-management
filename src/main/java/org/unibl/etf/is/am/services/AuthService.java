package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.models.dto.LoginResponse;
import org.unibl.etf.is.am.models.requests.LoginRequest;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
