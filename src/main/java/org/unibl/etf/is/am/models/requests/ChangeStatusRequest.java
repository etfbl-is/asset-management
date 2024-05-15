package org.unibl.etf.is.am.models.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.unibl.etf.is.am.models.enums.UserStatus;

@Data
public class ChangeStatusRequest {
    @NotNull
    private UserStatus status;
}
