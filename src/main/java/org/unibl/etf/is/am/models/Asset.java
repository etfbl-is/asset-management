package org.unibl.etf.is.am.models;

import lombok.Data;

@Data
public class Asset {
    private Integer id;
    private String identifier;
    private String name;
    private String description;
    private Integer locationId;
    private String locationName;
    private Integer assetTypeId;
    private String assetTypeName;
    private Integer assetStatusId;
    private String assetStatusName;
}
