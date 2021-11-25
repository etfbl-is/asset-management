package org.unibl.etf.is.am.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.is.am.base.CrudController;
import org.unibl.etf.is.am.models.AssetType;
import org.unibl.etf.is.am.models.AssetTypeRequest;
import org.unibl.etf.is.am.services.AssetTypeService;

@RestController
@RequestMapping("/asset-types")
public class AssetTypeController extends CrudController<Integer, AssetTypeRequest, AssetType> {
    public AssetTypeController(AssetTypeService service) {
        super(service, AssetType.class);
    }
}
