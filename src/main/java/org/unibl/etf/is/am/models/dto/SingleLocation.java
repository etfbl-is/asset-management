package org.unibl.etf.is.am.models.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleLocation extends Location {
    private List<Asset> assets;
}
