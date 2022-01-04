package org.unibl.etf.is.am.models.requests;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AssetTypeRequest {
    @NotBlank
    private String name;
    private String description;
}
