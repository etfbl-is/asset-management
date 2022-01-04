package org.unibl.etf.is.am.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.is.am.base.CrudJpaService;
import org.unibl.etf.is.am.exceptions.ConflictException;
import org.unibl.etf.is.am.models.entities.AssetTypeEntity;
import org.unibl.etf.is.am.repositories.AssetTypeEntityRepository;
import org.unibl.etf.is.am.services.AssetTypeService;

import javax.transaction.Transactional;

@Service
@Transactional
public class AssetTypeServiceImpl extends CrudJpaService<AssetTypeEntity, Integer> implements AssetTypeService {

    private AssetTypeEntityRepository repository;

    public AssetTypeServiceImpl(AssetTypeEntityRepository repository, ModelMapper modelMapper) {
        super(repository, modelMapper, AssetTypeEntity.class);
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
