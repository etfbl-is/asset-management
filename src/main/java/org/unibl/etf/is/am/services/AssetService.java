package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.base.CrudService;
import org.unibl.etf.is.am.models.Asset;

import java.util.List;

public interface AssetService extends CrudService<Integer> {
    List<Asset> getAllAssetsByLocationId(Integer id);
}
