package org.unibl.etf.is.am.models;

import lombok.Data;

@Data
public class AssetRequest {
    private String identifier;
    private String name;
    private String description;
    private Integer locationId;
    private Integer assetTypeId;
    private Integer assetStatusId;
}
