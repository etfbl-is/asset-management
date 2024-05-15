package org.unibl.etf.is.am.models.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AssetRequest {
    @NotBlank
    private String identifier;
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Integer locationId;
    @NotNull
    private Integer assetTypeId;
    @NotNull
    private Integer assetStatusId;
}
