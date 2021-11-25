package org.unibl.etf.is.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.base.CrudJpaService;
import org.unibl.etf.is.am.models.Asset;
import org.unibl.etf.is.am.models.entities.AssetEntity;
import org.unibl.etf.is.am.services.AssetService;
import org.unibl.etf.is.am.repositories.AssetEntityRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AssetServiceImpl extends CrudJpaService<AssetEntity, Integer> implements AssetService {
    private final ModelMapper modelMapper;
    private final AssetEntityRepository repository;

    public AssetServiceImpl(ModelMapper modelMapper, AssetEntityRepository repository) {
        super(repository, modelMapper, AssetEntity.class);
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

    @Override
    public List<Asset> getAllAssetsByLocationId(Integer id) {
        return repository.getAllByLocation_Id(id).stream().map(a -> modelMapper.map(a, Asset.class)).collect(Collectors.toList());
    }
}
