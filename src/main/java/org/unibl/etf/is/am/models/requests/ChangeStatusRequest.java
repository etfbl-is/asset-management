package org.unibl.etf.is.am.models.requests;

import lombok.Data;
import org.unibl.etf.is.am.models.enums.UserStatus;

import javax.validation.constraints.NotNull;

@Data
public class ChangeStatusRequest {
    @NotNull
    private UserStatus status;
}
