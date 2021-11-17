package org.unibl.etf.is.am.services;

import org.unibl.etf.is.am.exceptions.NotFoundException;
import org.unibl.etf.is.am.models.Asset;
import org.unibl.etf.is.am.models.AssetRequest;

import java.util.List;

public interface AssetService {
    List<Asset> findAll();
    Asset findById(Integer id) throws NotFoundException;

    List<Asset> getAllAssetsByLocationId(Integer id);

    Asset insert(AssetRequest assetRequest) throws NotFoundException;
    Asset update(Integer id,AssetRequest assetRequest) throws NotFoundException;

    void delete(Integer id);
}
