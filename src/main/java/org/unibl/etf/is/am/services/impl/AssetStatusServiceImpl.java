package org.unibl.etf.is.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.base.CrudJpaService;
import org.unibl.etf.is.am.models.entities.AssetStatusEntity;
import org.unibl.etf.is.am.services.AssetStatusService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AssetStatusServiceImpl extends CrudJpaService<AssetStatusEntity, Integer> implements AssetStatusService {
    public AssetStatusServiceImpl(JpaRepository<AssetStatusEntity, Integer> repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AssetStatusEntity.class);
    }
}
