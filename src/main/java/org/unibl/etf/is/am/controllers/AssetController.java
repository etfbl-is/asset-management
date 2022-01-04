package org.unibl.etf.is.am.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.is.am.exceptions.NotFoundException;
import org.unibl.etf.is.am.models.Asset;
import org.unibl.etf.is.am.models.AssetRequest;
import org.unibl.etf.is.am.services.AssetService;

import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    public AssetController(AssetService assetService) {
        this.assetService = assetService;
    }

    @GetMapping
    Page<Asset> findAll(Pageable page) {
        return assetService.findAll(page, Asset.class);
    }

    @GetMapping("/{id}")
    public Asset findById(@PathVariable Integer id) throws NotFoundException {
        return assetService.findById(id, Asset.class);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        assetService.delete(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Asset insert(@RequestBody AssetRequest assetRequest) throws NotFoundException {
        return assetService.insert(assetRequest, Asset.class);
    }

    @PutMapping("/{id}")
    public Asset update(@PathVariable Integer id, @RequestBody AssetRequest assetRequest) throws NotFoundException {
        return assetService.update(id, assetRequest, Asset.class);
    }
}
