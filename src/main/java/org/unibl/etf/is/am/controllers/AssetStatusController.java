package org.unibl.etf.is.am.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.is.am.base.CrudController;
import org.unibl.etf.is.am.models.AssetStatus;
import org.unibl.etf.is.am.models.AssetStatusRequest;
import org.unibl.etf.is.am.services.AssetStatusService;

@RestController
@RequestMapping("/asset-statuses")
public class AssetStatusController extends CrudController<Integer, AssetStatusRequest, AssetStatus> {
    public AssetStatusController(AssetStatusService service) {
        super(service, AssetStatus.class);
    }
}
