package org.unibl.etf.is.am.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.base.CrudJpaService;
import org.unibl.etf.is.am.exceptions.ConflictException;
import org.unibl.etf.is.am.models.entities.AssetStatusEntity;
import org.unibl.etf.is.am.repositories.AssetStatusEntityRepository;
import org.unibl.etf.is.am.services.AssetStatusService;

@Service
@Transactional
public class AssetStatusServiceImpl extends CrudJpaService<AssetStatusEntity, Integer> implements AssetStatusService {

    private AssetStatusEntityRepository repository;

    public AssetStatusServiceImpl(AssetStatusEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AssetStatusEntity.class);
        this.repository = repository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByName(getModelMapper().map(object, getEntityClass()).getName()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByNameAndIdNot(getModelMapper().map(object, getEntityClass()).getName(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }
}
