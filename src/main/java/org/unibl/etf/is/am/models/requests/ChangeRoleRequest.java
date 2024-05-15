package org.unibl.etf.is.am.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.unibl.etf.is.am.models.enums.Role;

@Data
public class ChangeRoleRequest {
    @NotNull
    private Role role;
}
