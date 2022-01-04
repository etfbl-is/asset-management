package org.unibl.etf.is.am.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.unibl.etf.is.am.base.CrudService;
import org.unibl.etf.is.am.models.Asset;

import java.util.List;

public interface AssetService extends CrudService<Integer> {
    List<Asset> getAllAssetsByLocationId(Integer id);

    <T> Page<T> findAll(Pageable page, Class<T> resultDtoClass);

}
