package org.unibl.etf.is.am.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.is.am.exceptions.ForbiddenException;
import org.unibl.etf.is.am.models.dto.JwtUser;
import org.unibl.etf.is.am.models.dto.User;
import org.unibl.etf.is.am.models.requests.ChangeRoleRequest;
import org.unibl.etf.is.am.models.requests.ChangeStatusRequest;
import org.unibl.etf.is.am.models.requests.UserUpdateRequest;
import org.unibl.etf.is.am.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getAll() {
        return service.findAll(User.class);
    }

    @PatchMapping("/{id}/status")
    public void changeStatus(@PathVariable Integer id, @RequestBody @Valid ChangeStatusRequest request, Authentication auth) {
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        if (jwtUser.getId().equals(id))
            throw new ForbiddenException();
        service.changeStatus(id, request);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Integer id, @Valid @RequestBody UserUpdateRequest request, Authentication auth) {
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        if (!jwtUser.getId().equals(id))
            throw new ForbiddenException();
        return service.update(id, request);
    }

    @PatchMapping("/{id}/role")
    public void changeRole(@PathVariable Integer id, @RequestBody @Valid ChangeRoleRequest request, Authentication auth) {
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        if (jwtUser.getId().equals(id))
            throw new ForbiddenException();
        service.changeRole(id, request);
    }
}
