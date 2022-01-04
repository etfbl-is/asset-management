package org.unibl.etf.is.am.models.dto;

import lombok.Data;
import org.unibl.etf.is.am.models.enums.Role;
import org.unibl.etf.is.am.models.enums.UserStatus;

@Data
public class User {
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private UserStatus status;
}
