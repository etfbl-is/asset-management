package org.unibl.etf.is.am.models.requests;

import lombok.Data;
import org.unibl.etf.is.am.models.enums.Role;

import javax.validation.constraints.NotNull;

@Data
public class ChangeRoleRequest {
    @NotNull
    private Role role;
}
