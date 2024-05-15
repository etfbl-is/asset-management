package org.unibl.etf.is.am.models.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AssetStatusRequest {
    @NotBlank
    private String name;
}
